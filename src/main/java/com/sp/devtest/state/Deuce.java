package com.sp.devtest.state;

import com.sp.devtest.Game;
import com.sp.devtest.Player;

public class Deuce implements State {

    private Game game;

    public Deuce(Game game) {
        this.game = game;
    }

    @Override
    public void pointScored(Player pointWinner, Player opponent) {
        pointWinner.setAdvantage(true);
        game.setState(game.getAdvantage());
    }

    @Override
    public String scoreString(Player player1, Player player2) {
        return "Deuce";
    }
}
