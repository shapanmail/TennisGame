package com.sp.devtest.state;

import com.sp.devtest.Game;
import com.sp.devtest.Player;


public class GameOver implements State {
    private Game game;

    public GameOver(Game game) {
        this.game = game;
    }

    @Override
    public void pointScored(Player pointWinner, Player opponent) {
        // nothing to do.
    }

    @Override
    public String scoreString(Player player1, Player player2) {
        Player winner = player1.isWinner() ? player1 : player2;
        return winner.getName() + " wins";
    }
}
