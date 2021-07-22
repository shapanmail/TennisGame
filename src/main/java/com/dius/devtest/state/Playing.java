package com.dius.devtest.state;

import com.dius.devtest.Game;
import com.dius.devtest.Player;


public class Playing implements State {
    private Game game;

    public Playing(Game game) {
        this.game = game;
    }

    @Override
    public void pointScored(Player pointWinner, Player opponent) {

        if (pointWinner.isIn40()) {
            pointWinner.setWinner(true);
            game.setState(game.getGameOver());
        } else {
            pointWinner.incrementPoint();
            // Deuce
            if (opponent.isIn40()) {
                game.setState(game.getDues());
            }
        }
    }

    @Override
    public String scoreString(Player player1, Player player2) {
        return player1.pointString() + "-" + player2.pointString();
    }
}
