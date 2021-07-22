package com.sp.devtest;

import com.dius.devtest.state.*;
import com.sp.devtest.state.*;


public class Game {
    private State state;

    private State playing;
    private State dues;
    private State advantage;
    private State gameOver;

    private Player player1, player2;

    public Game(String player1, String player2) {
        // player instantiate
        this.player1 = new Player(player1);
        this.player2 = new Player(player2);

        // state instantiate
        playing = new Playing(this);
        dues = new Deuce(this);
        advantage = new Advantage(this);
        gameOver = new GameOver(this);

        //initialize state
        this.state = playing;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void pointWonBy(String name) {
        // find winner and opponent from name
        Player pointWinner, opponent;
        if (player1.getName().equals(name)) {
            pointWinner = player1;
            opponent = player2;
        } else {
            pointWinner = player2;
            opponent = player1;
        }

        this.state.pointScored(pointWinner, opponent);
    }

    public String score() {
        return state.scoreString(player1, player2);
    }

    public State getDues() {
        return dues;
    }

    public State getAdvantage() {
        return advantage;
    }

    public State getGameOver() {
        return gameOver;
    }
}

