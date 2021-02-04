package com.Snake;

public class BoardSupervisor {

    Board board;
    Snake snake = new Snake();

    public BoardSupervisor() {
        board = new Board(10, 30);
        board.set(0,0,new Cell(CellType.POINT));
    }

    public Board move(Keys key) {
        return snake.move(board, key);
    }
}
