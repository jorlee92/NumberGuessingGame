/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import java.util.ArrayList;
import java.util.List;
import models.Game;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Game> getAllRounds(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void addNewGame(Game NewGame){
        Games.add(NewGame);
    }
    
    
    
}
