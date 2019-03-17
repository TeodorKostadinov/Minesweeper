package core;

import ui.ConsoleIO;
import ui.UserInput;

public class Game {

    public static final int GAME_WON = 1;
    public static final int GAME_LOST = 2;
    public static final int GAME_ACTIVE = 3;

    private Board board;
    private ConsoleIO userIO;

    public Game(int boardWidth, int boardHeight, int mineCount, ConsoleIO userIO) {
        this.board = new Board(boardWidth, boardHeight, mineCount);
        this.userIO = userIO;
    }

    public void start() {
        do {
            userIO.showBoard(getBoard());
            UserInput userInput = userIO.getUserInput(getBoardWidth(), getBoardHeight());
            executeMove(userInput);
        } while (isActive());

        userIO.showResult(getResult());
    }

    private boolean isActive() {
        return getResult() == GAME_ACTIVE;
    }

    private int getResult() {
        if(board.hasOpenMine()) {
            return GAME_LOST;
        } else if(board.areAllMinesFlagged()) {
            return GAME_WON;
        }
        return GAME_ACTIVE;
    }

    private int[][] getBoard() {
        return board.getVisibleBoard();
    }

    private int getBoardWidth() {
        return board.getWidth();
    }

    private int getBoardHeight() {
        return board.getHeight();
    }

    private void executeMove(UserInput userInput) {
        switch (userInput.getAction()) {
            case UserInput.ACTION_OPEN: board.openCell(userInput.getCellX(), userInput.getCellY()); break;
            case UserInput.ACTION_FLAG: board.flagCell(userInput.getCellX(), userInput.getCellY()); break;
        }
    }
}
