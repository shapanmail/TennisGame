package com.sp.devtest.state;

import com.sp.devtest.Player;


public interface State {
    public void pointScored(Player pointWinner, Player opponent);

    public String scoreString(Player player1, Player player2);
}
