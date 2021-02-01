package com.Snake;
import java.util.Scanner;

public class UserInput implements KeyTest {

    public Keys getInput() {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        return switch (a) {
            case "a" -> Keys.LEFT;
            case "d" -> Keys.RIGHT;
            case "s" -> Keys.DOWN;
            case "w" -> Keys.UP;
            default -> Keys.NONE;
        };
    }
}

