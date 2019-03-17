package ui;

public interface InputOutputDevice {
    void showResult(int minesweeperGameResult);
    void showBoard(int[][] board);
    UserInput getUserInput(int boardWidth, int boardHeight);
}
