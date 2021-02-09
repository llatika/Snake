package com.Snake;

public class Board {

    private final Cell[][] boardTable;

    public Board(int height, int width) {
        boardTable = new Cell[height][width];

        for (int i = 0; i < boardTable.length; i++) {
            for (int j = 0; j < boardTable[0].length; j++) {
                boardTable[i][j] = new Cell(CellType.EMPTY);
            }
        }
    }

    public void set(int y, int x, Cell cell) {
        boardTable[y][x] = cell;
    }

    public Cell get(int y, int x ) {
        return boardTable[y][x];
    }

    public int getLengthColumn() {
        return boardTable[0].length;
    }

    public int getLengthRows() {
        return boardTable.length;
    }

}
