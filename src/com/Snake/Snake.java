package com.Snake;

public class Snake {
    BoardSupervisor boardSupervisor = new BoardSupervisor();
    BoardDrawer boardDrawer = new BoardDrawer();
    UserInput userInput = new UserInput();
    Timer timer = new Timer();

    public void run() {
        while (true) {

            boardDrawer.draw(boardSupervisor.move());
            userInput.getInput();
            timer.sleep(1000);
        }
    }

}
