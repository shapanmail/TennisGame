package com.dius.devtest;


public class Player {
    private String name;
    private Point point;
    private boolean isWinner = false;
    private boolean advantage = false;

    public Player(String name) {
        this.name = name;
        this.point = Point.LOVE;
    }

    public void incrementPoint() {
        point = point.next();
    }

    public String getName() {
        return name;
    }

    public boolean isIn40() {
        return point == Point.FORTY;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        this.isWinner = winner;
    }

    public boolean isInAdvantage() {
        return advantage;
    }

    public void setAdvantage(boolean advantage) {
        this.advantage = advantage;
    }

    public String pointString() {
        return point.toString();
    }
}
