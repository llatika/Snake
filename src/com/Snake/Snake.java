package com.Snake;

import java.util.List;

public class Snake {

    private int xPosition, yPosition;
    private boolean busyUp,busyDown,busyRight, busyLeft=true;

    public Board move(Board board, Keys key, List<Coordinates> list) {

        xPosition = list.get(0).getX();
        yPosition = list.get(0).getY();
        switch (key) {

            case RIGHT -> {
               // if(!((board.get(list.get(0).getY()+1,list.get(0).getX()))==null)){
                if(!busyRight){
                board.set(list.get(list.size()-1).getX(), list.get(list.size()-1).getY(), new Cell(CellType.EMPTY));
                list.remove(list.size()-1);
                yPosition++;
                board.set(xPosition, yPosition, new Cell(CellType.POINT));
                list.add(0, new Coordinates(list.get(0).getX(),list.get(0).getY()+1));
                busyLeft=true;
                busyUp=false;
                busyDown=false;
                busyRight=false;}
            }
            case LEFT -> {
                if(!busyLeft){
                board.set(list.get(list.size()-1).getX(), list.get(list.size()-1).getY(), new Cell(CellType.EMPTY));
                list.remove(list.size()-1);
                yPosition--;
                board.set(xPosition, yPosition, new Cell(CellType.POINT));
                list.add(0, new Coordinates(list.get(0).getX(),list.get(0).getY()-1));
                busyRight=true;
                busyDown=false;
                busyUp=false;
                busyLeft=false;}

            }
            case DOWN -> {
                if(!busyDown){
                board.set(list.get(list.size()-1).getX(), list.get(list.size()-1).getY(), new Cell(CellType.EMPTY));
                list.remove(list.size()-1);
                xPosition++;
                board.set(xPosition, yPosition, new Cell(CellType.POINT));
                list.add(0, new Coordinates(list.get(0).getX()+1,list.get(0).getY()));
                busyUp=true;
                busyLeft=false;
                busyRight=false;
                busyDown=false;}
            }
            case UP -> {
                if(!busyUp){
                board.set(list.get(list.size()-1).getX(), list.get(list.size()-1).getY(), new Cell(CellType.EMPTY));
                list.remove(list.size()-1);
                xPosition--;
                board.set(xPosition, yPosition, new Cell(CellType.POINT));
                list.add(0, new Coordinates(list.get(0).getX()-1,list.get(0).getY()));
                busyDown=true;
                busyRight=false;
                busyLeft=false;
                busyUp=false;}
            }
            default -> {
                board.set(xPosition, yPosition, new Cell(CellType.POINT));
            }
        }
        return board;
    }
}
