package core;

import java.util.Random;

import static core.Board.CELL_MINE;

public class BoardUtils {

    public static int[][] generateFilledBoard(int boardWidth, int boardHeight, int fillValue) {
        int[][] board = new int[boardWidth][boardHeight];
        for (int x = 0; x < boardWidth; x++) {
            for (int y = 0; y < boardHeight; y++) {
                board[x][y] = fillValue;
            }
        }
        return board;
    }

    public static int[][] generateBoard(int boardWidth, int boardHeight, int mineCount) {
        int[][] board = new int[boardWidth][boardHeight];
        setMines(board, boardWidth, boardHeight, mineCount);
        setCellValues(board, boardWidth, boardHeight);
        return board;
    }

    private static void setCellValues(int[][] board, int boardWidth, int boardHeight) {
        for (int x = 0; x < boardWidth; x++) {
            for (int y = 0; y < boardHeight; y++) {
                if (board[x][y] != CELL_MINE) {
                    board[x][y] = getNumberOfNearbyMines(x, y, board, boardWidth, boardHeight);
                }
            }
        }
    }

    private static int getNumberOfNearbyMines(int x, int y, int[][] board, int boardWidth, int boardHeight) {
        int minesNearby = 0;
        if (x - 1 >= 0 && y + 1 < boardHeight && board[x - 1][y + 1] == CELL_MINE) minesNearby++;
        if (x >= 0 && y + 1 < boardHeight && board[x][y + 1] == CELL_MINE) minesNearby++;
        if (x + 1 < boardWidth && y + 1 < boardHeight && board[x + 1][y + 1] == CELL_MINE) minesNearby++;
        if (x + 1 < boardWidth && y < boardHeight && board[x + 1][y] == CELL_MINE) minesNearby++;
        if (x + 1 < boardWidth && y - 1 >= 0 && board[x + 1][y - 1] == CELL_MINE) minesNearby++;
        if (x < boardWidth && y - 1 >= 0 && board[x][y - 1] == CELL_MINE) minesNearby++;
        if (x - 1 >= 0 && y - 1 >= 0 && board[x - 1][y - 1] == CELL_MINE) minesNearby++;
        if (x - 1 >= 0 && y >= 0 && board[x - 1][y] == CELL_MINE) minesNearby++;
        return minesNearby;
    }

    private static void setMines(int[][] board, int boardWidth, int boardHeight, int mineCount) {
        int minesSet = 0;
        do {
            int randX = new Random().nextInt(boardWidth);
            int randY = new Random().nextInt(boardHeight);
            if (board[randX][randY] != CELL_MINE) {
                board[randX][randY] = CELL_MINE;
                minesSet++;
            }
        } while (minesSet != mineCount);
    }
}
