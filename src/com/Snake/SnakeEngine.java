package com.Snake;

public class SnakeEngine {
    BoardSupervisor boardSupervisor = new BoardSupervisor();
    BoardDrawer boardDrawer = new BoardDrawer();
    UserInput userInput = new UserInput();
    Timer timer = new Timer();

    public void run() {

        while (true) {
            Keys userKey = userInput.getInput();
            Board boardObject = boardSupervisor.move(userKey);
            boardDrawer.draw(boardObject);
            //timer.sleep(1000);
        }
    }
}
