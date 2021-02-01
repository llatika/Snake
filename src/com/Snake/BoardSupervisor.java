package com.Snake;

public class BoardSupervisor {

    Board board;
    Snake snake = new Snake();

    public BoardSupervisor() {
        board = new Board(5, 6);
    }

    public Board move(Keys key) {
        return snake.move(board, key);
    }
}
