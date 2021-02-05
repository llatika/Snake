package com.Snake;

import java.util.ArrayList;
import java.util.List;


public class BoardSupervisor {

    Board board;
    Snake snake = new Snake();
    int x;
    int y;
    List<Coordinates> coordinatesArray = new ArrayList<>();

    public BoardSupervisor() {
        board = new Board(10, 30);
        coordinatesArray.add(new Coordinates(0, 3));
        coordinatesArray.add(new Coordinates(0, 2));
        coordinatesArray.add(new Coordinates(0, 1));
        coordinatesArray.add(new Coordinates(0, 0));
        for (int i = 0; i < coordinatesArray.size(); i++) {
            board.set(coordinatesArray.get(i).getX(), coordinatesArray.get(i).getY(), new Cell(CellType.POINT));
        }
    }

    public Board move(Keys key, List<Coordinates> list) {
        return snake.move(board, key, list);
    }
}
