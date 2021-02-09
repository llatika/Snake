package com.Snake;

import java.util.List;

public class Snake {

    private boolean busyUp, busyDown, busyRight, busyLeft = true;

    public Board move(Board board, Keys key, List<Coordinates> list, Star star) throws SnakeOutOfIndexCustomException {

        int xPosition = list.get(0).getX();
        int yPosition = list.get(0).getY();
        int a = star.getStarX();
        int b=star.getStarY();
        switch (key) {

            case RIGHT -> {
                if (!busyRight) {

                    if (yPosition == star.getStarY() && xPosition+1 == star.getStarX()) {
                        board.set(yPosition, ++xPosition, new Cell(CellType.POINT));
                        list.add(0, new Coordinates(list.get(0).getY(), list.get(0).getX() + 1));
                    } else if (!isXNewCoordinate(board, xPosition+1)) {
                        throw new SnakeOutOfIndexCustomException();
                    } else {
                        board.set(list.get(list.size() - 1).getY(), list.get(list.size() - 1).getX(), new Cell(CellType.EMPTY));
                        list.remove(list.size() - 1);
                        board.set(yPosition, ++xPosition, new Cell(CellType.POINT));
                        list.add(0, new Coordinates(list.get(0).getY(), list.get(0).getX() + 1));
                        busyLeft = true;
                        busyUp = false;
                        busyDown = false;
                        busyRight = false;
                    }
                }
            }
            case LEFT -> {
                if (!busyLeft) {
                    if (yPosition == star.getStarY() && xPosition-1 == star.getStarX()) {
                        board.set(yPosition, --xPosition, new Cell(CellType.POINT));
                        list.add(0, new Coordinates(list.get(0).getY(), list.get(0).getX() - 1));

                    } else if (!isXNewCoordinate(board, xPosition-1)) {
                        throw new SnakeOutOfIndexCustomException();
                    } else {
                        board.set(list.get(list.size() - 1).getY(), list.get(list.size() - 1).getX(), new Cell(CellType.EMPTY));
                        list.remove(list.size() - 1);
                        board.set(yPosition, --xPosition, new Cell(CellType.POINT));
                        list.add(0, new Coordinates(list.get(0).getY(), list.get(0).getX() - 1));
                        busyRight = true;
                        busyDown = false;
                        busyUp = false;
                        busyLeft = false;
                    }
                }

            }
            case DOWN -> {
                if (!busyDown) {
                    if (yPosition+1 == star.getStarY() && xPosition == star.getStarX()) {
                        board.set(++yPosition, xPosition, new Cell(CellType.POINT));
                        list.add(0, new Coordinates(list.get(0).getY() + 1, list.get(0).getX()));

                    } else if (!isYNewCoordinate(board, yPosition+1)) {
                        throw new SnakeOutOfIndexCustomException();
                    } else {
                        board.set(list.get(list.size() - 1).getY(), list.get(list.size() - 1).getX(), new Cell(CellType.EMPTY));
                        list.remove(list.size() - 1);
                        board.set(++yPosition, xPosition, new Cell(CellType.POINT));
                        list.add(0, new Coordinates(list.get(0).getY() + 1, list.get(0).getX()));
                        busyUp = true;
                        busyLeft = false;
                        busyRight = false;
                        busyDown = false;
                    }
                }
            }
            case UP -> {
                if (!busyUp) {
                    if (yPosition-1 == star.getStarY() && xPosition == star.getStarX()) {
                        board.set(--yPosition, xPosition, new Cell(CellType.POINT));
                        list.add(0, new Coordinates(list.get(0).getY() - 1, list.get(0).getX()));

                    } else if (!isYNewCoordinate(board, yPosition-1)) {
                        throw new SnakeOutOfIndexCustomException();
                    } else {
                        board.set(list.get(list.size() - 1).getY(), list.get(list.size() - 1).getX(), new Cell(CellType.EMPTY));
                        list.remove(list.size() - 1);
                        board.set(--yPosition, xPosition, new Cell(CellType.POINT));
                        list.add(0, new Coordinates(list.get(0).getY() - 1, list.get(0).getX()));
                        busyDown = true;
                        busyRight = false;
                        busyLeft = false;
                        busyUp = false;
                    }
                }
            }
            default -> {
                board.set(yPosition, xPosition, new Cell(CellType.POINT));
            }
        }
        return board;
    }

    public boolean isYNewCoordinate(Board board, int param) {
        if (param < 0 || param >= board.getLengthColumn()) return false;
        else return true;
    }

    public boolean isXNewCoordinate(Board board, int param) {
        if (param < 0 || param >= board.getLengthColumn()) return false;
        else return true;
    }
}
