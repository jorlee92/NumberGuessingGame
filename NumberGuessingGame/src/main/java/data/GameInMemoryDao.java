/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import data.GameDao;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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
    
    private ArrayList<Game> list;
    
    public GameInMemoryDao(){
        this.list = new ArrayList<Game>();
    }
    
    @Override
    public List<Game> getAll() {
        return this.list;
    }

    @Override
    public Game getById(int id) {
       return this.list.stream().filter(x -> x.getId() == id).collect(Collectors.toList()).get(0);
    }

    @Override
    public List<Game> getAllID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
