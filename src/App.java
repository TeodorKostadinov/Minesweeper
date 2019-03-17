import core.Game;
import ui.ConsoleIO;

public class App {

    public static void main(String[] args) {
        ConsoleIO consoleIO = new ConsoleIO();
        Game minesweeperGame = new Game(10, 10, 5, consoleIO);
        minesweeperGame.start();
    }
}
