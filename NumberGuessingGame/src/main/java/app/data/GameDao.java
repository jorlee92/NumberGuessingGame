/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.data;

import java.util.List;
import app.models.Game;
import app.models.Round;

/**
 *
 * @author chadb
 */
public interface GameDao {
    
    List<Game> getAll();
    
    Game getById(int id);
    
    List<Round> getAllRounds(int id);
        
     public void addNewGame(Game NewGame);
    
}
