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
import models.Round;

/**
 *
 * @author chadb
 */
public class GameInMemoryDao implements GameDao{
    
    private ArrayList<Game> list;
    private ArrayList<Round> rounds;
    
    @Override
    public List<Round> getAllRounds(int id) {
        return rounds;
    }
    
    public void addNewGame(Game NewGame){
        list.add(NewGame);
    }
        
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
    
}
