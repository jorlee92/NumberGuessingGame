/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import app.data.GameDao;
import app.data.GameInMemoryDao;
import app.models.Game;
import app.models.Guess;
import app.models.Round;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    public Controller() {
        dao = new GameInMemoryDao();
    }
    
    
    
    @PostMapping("/game")
    @ResponseStatus(HttpStatus.CREATED)
    public Game create() {
        Game g = new Game();
        dao.addNewGame(g);
        return g;
    }
    
    //"guess" – POST – Makes a guess by passing the guess and gameId in as JSON. 
    //The program must calculate the results of the guess and mark the game finished 
    //if the guess is correct. It returns the Round object with the results filled in.
    @PostMapping("/guess")
    public Round guess(@RequestBody Guess g){
        Round r = new Round();
        Game game = dao.getById(g.getGameID());
        r.setGuess(g.getGuess());
        if(r.getGuess().equals(game.getAnswer())){
            r.setGuessResult("Correct");
        } else {
            r.setGuessResult("Incorrect");
        }
        return r;
    }
}
