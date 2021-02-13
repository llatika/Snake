package com.Snake;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class BoardSupervisor {

    Board board;
    Snake snake = new Snake();
    List<Coordinates> coordinatesArray = new ArrayList<>();
StarGenerator starGenerator= new StarGenerator();
    public BoardSupervisor() {
        board = new Board(10, 30);
        coordinatesArray.add(new Coordinates(0, 3));
        coordinatesArray.add(new Coordinates(0, 2));
        coordinatesArray.add(new Coordinates(0, 1));
        coordinatesArray.add(new Coordinates(0, 0));
        for (Coordinates coordinates : coordinatesArray) {
            board.set(coordinates.getY(), coordinates.getX(), new Cell(CellType.POINT));
        }
        starGenerator.randStar(board,coordinatesArray);
        board.set(starGenerator.star.getStarY(), starGenerator.star.getStarX(), new Cell(CellType.STAR));
    }

    public Board move(Keys key, List<Coordinates> list) throws SnakeOutOfIndexCustomException {
        Board boardSnake = snake.move(board, key, list, starGenerator.star);
        if(snake.getIsEatenValue()){
        starGenerator.randStar(boardSnake, list);
        snake.setIsEatenValueFalse();}
        return boardSnake;
    }

}

