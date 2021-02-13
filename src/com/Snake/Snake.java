package com.Snake;

import java.security.Key;
import java.util.List;

public class Snake {

    private boolean busyUp, busyDown, busyRight, busyLeft = true, isEaten;

    public Board move(Board board, Keys key, List<Coordinates> list, Star star) throws SnakeOutOfIndexCustomException {
        int xPosition = list.get(0).getX();
        int yPosition = list.get(0).getY();
        switch (key) {

            case RIGHT -> {
                if (!busyRight) {

                    if (yPosition == star.getStarY() && xPosition + 1 == star.getStarX()) {
                        board.set(yPosition, ++xPosition, new Cell(CellType.POINT));
                        list.add(0, new Coordinates(list.get(0).getY(), list.get(0).getX() + 1));
                        setAccessPermissions(Keys.RIGHT);
                        isEaten = true;
                    } else if (!isXNewCoordinate(board, xPosition + 1) || isSnakeEatOwnBody(Keys.RIGHT, list,xPosition,yPosition)) {
                        throw new SnakeOutOfIndexCustomException();
                    } else {
                        board.set(list.get(list.size() - 1).getY(), list.get(list.size() - 1).getX(), new Cell(CellType.EMPTY));
                        list.remove(list.size() - 1);
                        board.set(yPosition, ++xPosition, new Cell(CellType.POINT));
                        list.add(0, new Coordinates(list.get(0).getY(), list.get(0).getX() + 1));
                        setAccessPermissions(Keys.RIGHT);
                    }
                }
            }
            case LEFT -> {
                if (!busyLeft) {
                    if (yPosition == star.getStarY() && xPosition - 1 == star.getStarX()) {
                        board.set(yPosition, --xPosition, new Cell(CellType.POINT));
                        list.add(0, new Coordinates(list.get(0).getY(), list.get(0).getX() - 1));
                        setAccessPermissions(Keys.LEFT);
                        isEaten = true;
                    } else if (!isXNewCoordinate(board, xPosition - 1) || isSnakeEatOwnBody(Keys.LEFT, list,xPosition,yPosition)) {
                        throw new SnakeOutOfIndexCustomException();
                    } else {
                        board.set(list.get(list.size() - 1).getY(), list.get(list.size() - 1).getX(), new Cell(CellType.EMPTY));
                        list.remove(list.size() - 1);
                        board.set(yPosition, --xPosition, new Cell(CellType.POINT));
                        list.add(0, new Coordinates(list.get(0).getY(), list.get(0).getX() - 1));
                        setAccessPermissions(Keys.LEFT);
                    }
                }

            }
            case DOWN -> {
                if (!busyDown) {
                    if (yPosition + 1 == star.getStarY() && xPosition == star.getStarX()) {
                        board.set(++yPosition, xPosition, new Cell(CellType.POINT));
                        list.add(0, new Coordinates(list.get(0).getY() + 1, list.get(0).getX()));
                        setAccessPermissions(Keys.DOWN);
                        isEaten = true;
                    } else if (!isYNewCoordinate(board, yPosition + 1) || isSnakeEatOwnBody(Keys.DOWN, list,xPosition,yPosition)) {
                        throw new SnakeOutOfIndexCustomException();
                    } else {
                        board.set(list.get(list.size() - 1).getY(), list.get(list.size() - 1).getX(), new Cell(CellType.EMPTY));
                        list.remove(list.size() - 1);
                        board.set(++yPosition, xPosition, new Cell(CellType.POINT));
                        list.add(0, new Coordinates(list.get(0).getY() + 1, list.get(0).getX()));
                        setAccessPermissions(Keys.DOWN);
                    }
                }
            }
            case UP -> {
                if (!busyUp) {
                    if (yPosition - 1 == star.getStarY() && xPosition == star.getStarX()) {
                        board.set(--yPosition, xPosition, new Cell(CellType.POINT));
                        list.add(0, new Coordinates(list.get(0).getY() - 1, list.get(0).getX()));
                        setAccessPermissions(Keys.UP);
                        isEaten = true;
                    } else if (!isYNewCoordinate(board, yPosition - 1) || isSnakeEatOwnBody(Keys.UP, list,xPosition,yPosition)) {
                        throw new SnakeOutOfIndexCustomException();
                    } else {
                        board.set(list.get(list.size() - 1).getY(), list.get(list.size() - 1).getX(), new Cell(CellType.EMPTY));
                        list.remove(list.size() - 1);
                        board.set(--yPosition, xPosition, new Cell(CellType.POINT));
                        list.add(0, new Coordinates(list.get(0).getY() - 1, list.get(0).getX()));
                        setAccessPermissions(Keys.UP);
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
        return param >= 0 && param < board.getLengthColumn();
    }

    public boolean isXNewCoordinate(Board board, int param) {
        return param >= 0 && param < board.getLengthColumn();
    }

    public boolean isSnakeEatOwnBody(Keys key, List<Coordinates> list, int xPos, int yPos) {
        switch (key) {
            case RIGHT -> {
               return (isElementInList(list, xPos+1, yPos ));
            }
            case LEFT -> {
                return (isElementInList(list, xPos-1, yPos ));
            }
            case DOWN -> {
                return (isElementInList(list, xPos, yPos+1 ));
            }
            case UP -> {
                return (isElementInList(list, xPos, yPos -1 ));
            }
            default -> {
            }
        }
        return false;
    }

    public boolean isElementInList(List<Coordinates> list, int xPos, int yPos){
        for (Coordinates coordinates : list) {
            if (coordinates.getX() == xPos && coordinates.getY() == yPos) return true;
        }
        return false;
    }


    public void setAccessPermissions(Keys key) {
        switch (key) {
            case RIGHT: {
                busyLeft = true;
                busyUp = false;
                busyDown = false;
                busyRight = false;
            }
            break;
            case LEFT: {
                busyRight = true;
                busyLeft = false;
                busyUp = false;
                busyDown = false;
            }
            break;
            case DOWN: {
                busyUp = true;
                busyRight = false;
                busyLeft = false;
                busyDown = false;
            }
            break;
            case UP: {
                busyDown = true;
                busyUp = false;
                busyRight = false;
                busyLeft = false;
            }
            break;
            case NONE: {
            }
            default: {
            }
        }
    }

    public boolean getIsEatenValue() {
        return isEaten;
    }

    public void setIsEatenValueFalse() {
        isEaten = false;
    }
}
