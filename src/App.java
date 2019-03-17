import core.Game;
import ui.ConsoleIO;
import ui.UserInput;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ConsoleIO consoleIO = new ConsoleIO();
        Game minesweeperGame = new Game(3, 6, 10);

        do {
            consoleIO.showBoard(minesweeperGame.getBoard());
            UserInput userInput = consoleIO.getUserInput(
                    minesweeperGame.getBoardWidth(), minesweeperGame.getBoardHeight());
            //play move
        } while (minesweeperGame.isActive());

        consoleIO.showResult(minesweeperGame.getResult());
    }
}
