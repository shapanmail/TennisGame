package com.sp.devtest.state;

import com.sp.devtest.Game;
import com.sp.devtest.Player;


public class Advantage implements State {
    private Game game;

    public Advantage(Game game) {
        this.game = game;
    }

    @Override
    public void pointScored(Player pointWinner, Player opponent) {
        if (pointWinner.isInAdvantage()) {
            pointWinner.setWinner(true);
            game.setState(game.getGameOver());
        } else {
            // Deuce
            opponent.setAdvantage(false);
            game.setState(game.getDues());
        }
    }

    @Override
    public String scoreString(Player player1, Player player2) {
        String name = player1.isInAdvantage() ? player1.getName() : player2.getName();
        return "Advantage " + name;
    }
}
