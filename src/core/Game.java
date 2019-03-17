package core;

import ui.UserInput;

public class Game {

    public static final int GAME_WON = 1;
    public static final int GAME_LOST = 2;
    public static final int GAME_ACTIVE = 3;

    private Board board;

    public Game(int boardWidth, int boardHeight, int mineCount) {
        this.board = new Board(boardWidth, boardHeight, mineCount);
    }

    public boolean isActive() {
        return getResult() == GAME_ACTIVE;
    }

    public int getResult() {
        if(board.hasOpenMine()) {
            return GAME_LOST;
        } else if(board.areAllMinesFlagged()) {
            return GAME_WON;
        }
        return GAME_ACTIVE;
    }

    public int[][] getBoard() {
        return board.getVisibleBoard();
    }

    public int getBoardWidth() {
        return board.getWidth();
    }

    public int getBoardHeight() {
        return board.getHeight();
    }

    public void executeMove(UserInput userInput) {
        switch (userInput.getAction()) {
            case UserInput.ACTION_OPEN: board.openCell(userInput.getCellX(), userInput.getCellY()); break;
            case UserInput.ACTION_FLAG: board.flagCell(userInput.getCellX(), userInput.getCellY()); break;
        }
    }
}
