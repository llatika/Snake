package com.Snake;

public class BoardDrawer {

    public void draw(Board board) {
        for (int i = 0; i < board.getLengthRows(); i++) {
            System.out.println();
            for (int j = 0; j < board.getLengthColumn(); j++) {
                drawCell(board.get(i, j));
            }
        }
    }

    public void clearScreen() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    private void drawCell(Cell cell) {
        switch (cell.getCellType()) {
            case EMPTY -> System.out.print("*");
            case POINT -> System.out.print("0");
            case STAR -> System.out.print("%");
        }
    }
}
