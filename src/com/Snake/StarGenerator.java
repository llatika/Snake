package com.Snake;

import java.util.List;
import java.util.Random;

public class StarGenerator {
    Star star= new Star(0,0);

    public void randStar(Board board, List<Coordinates> list) {
        Random rand = new Random();
        int xRand = 0, yRand = 0;

        do {
            yRand = rand.nextInt(board.getLengthRows());
            xRand = rand.nextInt(board.getLengthColumn());
        }
        while (areNumbersAccessible(list, xRand, yRand));
        star.setStarX(xRand);
        star.setStarY(yRand);

        board.set(yRand, xRand, new Cell(CellType.STAR));
    }


    public boolean areNumbersAccessible(List<Coordinates> list, int xRand, int yRand) {
        for (Coordinates coordinates :list)
            return xRand == coordinates.getX() &&
                    yRand == coordinates.getY();
        return false;
    }
}
