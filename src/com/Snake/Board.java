package com.Snake;

import java.awt.*;

public class Board {

    private Cell[][] boardTable;

    public Board(int width, int height) {
        boardTable = new Cell[width][height];

        for (int i = 0; i < boardTable.length; i++) {
            for (int j = 0; j < boardTable[0].length; j++) {
                boardTable[i][j] = new Cell(CellType.EMPTY);
            }
        }

     /*   boardTable[boardTable.length/2-1][0]= new Cell(CellType.POINT);
        boardTable[boardTable.length/2-1][1] = new Cell(CellType.POINT);*/
        boardTable[boardTable.length/2-1][2] = new Cell(CellType.POINT);
    }

    public void set(int x, int y, Cell cell) {
        boardTable[x][y] = cell;
    }

    public Cell get(int width, int height) {
        return boardTable[width][height];
    }

    public int getLengthColumn() {
        return boardTable.length;
    }

    public int getLengthRows() {
        return boardTable[0].length;
    }
}
