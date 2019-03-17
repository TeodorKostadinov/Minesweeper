package core;

public class Game {

    public static final int GAME_WON = 1;
    public static final int GAME_LOST = 2;
    public static final int GAME_ACTIVE = 3;

    int[][] board;

    public Game(int boardWidth, int boardHeight, int mineCount) {
        //TODO
        this.board = new int[boardWidth][boardHeight];
    }

    public boolean isActive() {
        return getResult() == GAME_ACTIVE;
    }

    public int getResult() {
        //TODO
        return GAME_ACTIVE;
    }

    public int[][] getBoard() {
        return board;
    }

    public int getBoardWidth() {
        return board.length;
    }

    public int getBoardHeight() {
        return board[0].length;
    }
}
