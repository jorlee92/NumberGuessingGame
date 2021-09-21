/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import app.data.GameInMemoryDao;
import app.models.Game;
import app.models.Guess;
import app.models.Round;
import app.service.Service;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chadb
 */
@RestController
@RequestMapping("/api")
public class Controller {
   
    GameInMemoryDao dao;
    Service service = new Service();
    public Controller() {
        dao = new GameInMemoryDao();
    }
    
    
    
    @PostMapping("/game")
    @ResponseStatus(HttpStatus.CREATED)
    public Game create() {
        Game g = new Game();
        g.setAnswer(service.generateAnswer());
        dao.addNewGame(g);
        return g;
    }
    
    @GetMapping("/game")
    public List<Game> getGames(){
        return dao.getAll();
    }
    
    @GetMapping("/guess")
    public List<Round> getGuesses(){
        return dao.getAllRounds(0);
    }
    
    @GetMapping("/rounds/{id}")
    public List<Round> getRoundsById(@PathVariable int id){
        return this.getGames().stream().filter(x-> x.getId() == id).findFirst().orElse(null).getRounds();
    }
    //"guess" – POST – Makes a guess by passing the guess and gameId in as JSON. 
    //The program must calculate the results of the guess and mark the game finished 
    //if the guess is correct. It returns the Round object with the results filled in.
    @PostMapping("/guess")
    public Round guess(@RequestBody Guess g){
        Round r = new Round();
        dao.getAllRounds(0).add(r);
        Game game = dao.getById(g.getGameID());
        if(game.isStatus()){
            r.setGuessResult("Game is finished, feel free to start a new game at /api/game !");
            return r;
        }
        r.setGuess(g.getGuess());
        System.out.println("<---- Debugging ---->");
        System.out.println(game.getAnswer() + " " + game.getId());
        System.out.println(g.getGameID() + " " + g.getGuess());
        System.out.println(r + " " +  r.getGuess());
        System.out.println("<---- Debugging ---->");
        r.setGuessResult(service.getRoundResult(game.getAnswer(), g.getGuess()));
        if(r.getGuessResult().equals("e:4:p:0")){
            game.setStatus(true);
        }
        r.setTimestamp(LocalDateTime.now());
        game.addRound(r);
        return r;
    }
}
