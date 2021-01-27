package com.Snake;

import java.util.Arrays;

public class BoardDrawer {

    public void draw(Board board) {
        for (int i = 0; i < board.getLengthColumn(); i++) {
            System.out.println();
            for (int j = 0; j < board.getLengthRows(); j++) {
                drawCell(board.get(i, j));
            }
        }
    }

    private void drawCell(Cell cell){
        if(cell.getCellType() == CellType.EMPTY)
        {
            System.out.print("*");
        }
        else System.out.print("O");
    }
}
