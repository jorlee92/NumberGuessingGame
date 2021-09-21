/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import static java.lang.constant.ConstantDescs.NULL;
import java.util.ArrayList;
import java.util.List;
import models.Game;
import models.Round;

/**
 *
 * @author chadb
 */
public class GameInMemoryDao implements GameDao{
    
    private static final List<Game> Games = new ArrayList<>();

    @Override
    public List<Game> getAll() {
        return new ArrayList<>(Games);
    }

    @Override
    public Game getById(int id) {
        return Games.stream()
                .filter(i-> i.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Round> getAllRounds(int id) {
        Game ThisGame = Games.stream()
                .filter(i-> i.getId() == id)
                .findAny()
                .orElse(null);
        return ThisGame.getRounds();
    }
    
    public void addNewGame(Game NewGame){
        Games.add(NewGame);
    }
    
    
    
}
