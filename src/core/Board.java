package core;

import java.util.Random;

public class Board {

    public final static int CELL_MINE = -1;
    public final static int CELL_CLOSED = -2;
    public final static int CELL_FLAG = -3;

    private int[][] visibleBoard;
    private int[][] valuesBoard;

    public Board(int boardWidth, int boardHeight, int mineCount) {
        this.valuesBoard = BoardUtils.generateBoard(boardWidth, boardHeight, mineCount);
        this.visibleBoard = BoardUtils.generateFilledBoard(boardWidth, boardHeight, CELL_CLOSED);
    }

    public int[][] getVisibleBoard() {
        return visibleBoard;
    }

    public int getWidth() {
        return visibleBoard.length;
    }

    public int getHeight() {
        return visibleBoard[0].length;
    }

    public boolean hasOpenMine() {
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                if(visibleBoard[x][y] == CELL_MINE) return true;
            }
        }
        return false;
    }

    public boolean areAllMinesFlagged() {
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                if(valuesBoard[x][y] == CELL_MINE && visibleBoard[x][y] != CELL_FLAG) return false;
            }
        }
        return true;
    }

    public void flagCell(int cellX, int cellY) {
        if(visibleBoard[cellX][cellY] == CELL_CLOSED) {
            visibleBoard[cellX][cellY] = CELL_FLAG;
        }
    }

    public void openCell(int cellX, int cellY) {
        if(cellX < 0 || cellY < 0 || cellX >= getWidth() || cellY >= getHeight()) return;
        if(visibleBoard[cellX][cellY] == CELL_CLOSED || visibleBoard[cellX][cellY] == CELL_FLAG) {
            visibleBoard[cellX][cellY] = valuesBoard[cellX][cellY];
            if (visibleBoard[cellX][cellY] == 0) {
                openCell(cellX - 1, cellY - 1);
                openCell(cellX - 1, cellY);
                openCell(cellX - 1, cellY + 1);
                openCell(cellX, cellY + 1);
                openCell(cellX + 1, cellY + 1);
                openCell(cellX + 1, cellY);
                openCell(cellX + 1, cellY - 1);
                openCell(cellX, cellY - 1);
            }
        }
    }
}
