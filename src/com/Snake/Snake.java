package com.Snake;

public class Snake {

    private int xPosition = 0, yPosition = 0;

    public Board move(Board board, Keys key) {
        switch (key) {
            case RIGHT -> {
                board.set(xPosition, yPosition, new Cell(CellType.EMPTY));
                yPosition++;
                board.set(xPosition, yPosition, new Cell(CellType.POINT));
            }
            case LEFT -> {
                board.set(xPosition, yPosition, new Cell(CellType.EMPTY));
                yPosition--;
                board.set(xPosition, yPosition, new Cell(CellType.POINT));

            }
            case DOWN -> {
                board.set(xPosition, yPosition, new Cell(CellType.EMPTY));
                xPosition++;
                board.set(xPosition, yPosition, new Cell(CellType.POINT));
            }
            case UP -> {
                board.set(xPosition, yPosition, new Cell(CellType.EMPTY));
                xPosition--;
                board.set(xPosition, yPosition, new Cell(CellType.POINT));
            }
            default -> {
                board.set(xPosition, yPosition, new Cell(CellType.POINT));
            }
        }
        return board;
    }
}
