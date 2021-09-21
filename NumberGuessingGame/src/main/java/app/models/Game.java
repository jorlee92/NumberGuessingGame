/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Austin Graham, Chandler Bottomley, Jordan Lee
 */
public class Game {
    
    private int Id;
    private String answer;
    private boolean status;
    private static int lastID =0;
    List<Round> Rounds = new ArrayList<>();
    
    public Game(){
        this.setId(lastID);
        this.lastID = this.lastID + 1;
    }
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.Id;
        hash = 97 * hash + Integer.parseInt(answer);
        hash = 97 * hash + (this.status ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (this.Id != other.Id) {
            return false;
        }
        if (this.answer != other.answer) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "Id=" + Id + ", answer=" + answer + ", status=" + status + '}';
    }
    
    public List<Round> getRounds(){
        return Rounds;
    }
    
    public void addRound(Round R){
        Rounds.add(R);
    }
    
    
}
