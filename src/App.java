import core.Game;
import ui.ConsoleIO;

public class App {
    public static void main(String[] args) {
        ConsoleIO consoleIO = new ConsoleIO();
        Game minesweeperGame = new Game(10, 10, 10);

        do {
            //draw
            //get input from user
            //play move
        } while (minesweeperGame.isActive());

        consoleIO.showResult(minesweeperGame.getResult());
    }
}
