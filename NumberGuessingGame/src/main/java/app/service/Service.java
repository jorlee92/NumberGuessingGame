/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import models.Game;
import models.Round;

/**
 *
 * @author chadb
 */
public class Service {
    
    public String generateAnswer(){
        
        String result = "";
        
        for(int i = 0; i < 4; i++){
            int random  = (int)((Math.random() * (10)));
            
            //if my result doesn't contain the new generated digit then I add it to the result
            if(!result.contains(Integer.toString(random))){
                result+=Integer.toString(random);
            }
        }
        return result;    
    }
    
    public String getRoundResult(String answer, String guess){
        String result = "";
        int exact = 0;
        int partial = 0;
        
        for(int i = 0; i < 4; i++){
            if(answer.charAt(i) == guess.charAt(i)){
                exact++;
            }
            else{
                for(int j = 0; j < 4; j++){
                    if(answer.charAt(j) == guess.charAt(i)){
                        partial++;
                    }
                }
            }
        }
        return "e:"+exact+":p:"+partial;
    }
}
