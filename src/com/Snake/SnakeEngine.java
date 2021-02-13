package com.Snake;

public class SnakeEngine {
    BoardSupervisor boardSupervisor = new BoardSupervisor();
    BoardDrawer boardDrawer = new BoardDrawer();
    UserInput userInput = new UserInput();
    Timer timer = new Timer();

    public void run() {

        boardDrawer.draw(boardSupervisor.board);
        while (true) {
            System.out.println();
            System.out.println();
            System.out.print(">>> ");
            Keys userKey = userInput.getInput();
            Board boardObject = null;

            try {
                boardObject = boardSupervisor.move(userKey, boardSupervisor.coordinatesArray);
            } catch (SnakeOutOfIndexCustomException e) {
                gameOver();
                break;
            }

            boardDrawer.draw(boardObject);
            timer.sleep(500);
        }
    }

    public void gameOver() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Game over!");
    }
}
