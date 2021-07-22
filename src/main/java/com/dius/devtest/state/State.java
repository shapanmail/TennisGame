package com.dius.devtest.state;

import com.dius.devtest.Player;


public interface State {
    public void pointScored(Player pointWinner, Player opponent);

    public String scoreString(Player player1, Player player2);
}
