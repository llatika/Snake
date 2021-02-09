package com.Snake;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class BoardSupervisor {

    Board board;
    Snake snake = new Snake();
    List<Coordinates> coordinatesArray = new ArrayList<>();
Star star= new Star(0,0);

    public BoardSupervisor() {
        board = new Board(10, 30);
        coordinatesArray.add(new Coordinates(0, 3));
        coordinatesArray.add(new Coordinates(0, 2));
        coordinatesArray.add(new Coordinates(0, 1));
        coordinatesArray.add(new Coordinates(0, 0));
        for (int i = 0; i < coordinatesArray.size(); i++) {
            board.set(coordinatesArray.get(i).getY(), coordinatesArray.get(i).getX(), new Cell(CellType.POINT));
        }
        randStar();
        board.set(star.getStarY(), star.getStarX(), new Cell(CellType.STAR));
    }

    public Board move(Keys key, List<Coordinates> list, Star star) throws SnakeOutOfIndexCustomException {
        return snake.move(board, key, list, star);
    }

    public void randStar() {
        Random rand = new Random();
        int xRand = 0, yRand = 0;

        do {
            yRand = rand.nextInt(board.getLengthRows());
            xRand = rand.nextInt(board.getLengthColumn());
        }
        while (areNumbersAccessible(xRand, yRand));
        star.setStarX(xRand);
        star.setStarY(yRand);
    }


    public boolean areNumbersAccessible(int xRand, int yRand) {
        for (Coordinates coordinates : coordinatesArray)
            return xRand == coordinates.getX() &&
                    yRand == coordinates.getY();

        return false;
    }
}

