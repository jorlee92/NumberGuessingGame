/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.List;
import models.Game;

/**
 *
 * @author chadb
 */
public interface GameDoa {
    
    List<Game> getAll();
    
    Game getById(int id);
    
    List<Game> getAllID(int id);
    
    
    
}
