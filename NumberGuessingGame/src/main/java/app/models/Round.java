/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author agrah
 */
public class Round {
    
    private String guess;
    private LocalDateTime timestamp;
    private String guessResult;

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getGuessResult() {
        return guessResult;
    }

    public void setGuessResult(String guessResult) {
        this.guessResult = guessResult;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        //Probably gonna break easily due to my dumb change.
        hash = 67 * hash + this.guess.toCharArray().length;
        hash = 67 * hash + Objects.hashCode(this.timestamp);
        hash = 67 * hash + Objects.hashCode(this.guessResult);
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
        final Round other = (Round) obj;
        if (this.guess != other.guess) {
            return false;
        }
        if (!Objects.equals(this.guessResult, other.guessResult)) {
            return false;
        }
        if (!Objects.equals(this.timestamp, other.timestamp)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Round{" + "guess=" + guess + ", timestamp=" + timestamp + ", guessResult=" + guessResult + '}';
    }
    
    
}
