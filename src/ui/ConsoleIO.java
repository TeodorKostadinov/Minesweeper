package ui;

import core.Game;

public class ConsoleIO {

    public void showResult(int minesweeperGameResult) {
        switch (minesweeperGameResult) {
            case Game.GAME_WON: System.out.println("Congratulations. You won!"); break;
            case Game.GAME_LOST: System.out.println("Mine exploded. You lost!"); break;
            default: System.out.println("Unknown state.");
        }
    }
}
