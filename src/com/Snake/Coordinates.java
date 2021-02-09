package com.Snake;

public class Coordinates {
    private int x;
    private int y;

    Coordinates(int yCoordinate, int xCoordinate){
        this.x = xCoordinate;
        this.y= yCoordinate;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
