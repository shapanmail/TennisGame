package com.dius.devtest;


public enum Point {

    LOVE("0"), FIFTEEN("15"), THIRTY("30"), FORTY("40");

    private String pointString;

    Point(String pointString) {
        this.pointString = pointString;
    }

    public String toString() {
        return this.pointString;
    }

    public Point next() {
        Point[] points = values();
        int index = this.ordinal();
        assert (index < points.length - 1);
        return points[index + 1];
    }

}
