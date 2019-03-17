package ui;

import core.Board;
import core.Game;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ConsoleIO implements InputOutputDevice {

    @Override
    public void showResult(int minesweeperGameResult) {
        switch (minesweeperGameResult) {
            case Game.GAME_WON: System.out.println("Congratulations. You won!"); break;
            case Game.GAME_LOST: System.out.println("Mine exploded. You lost!"); break;
            default: System.out.println("Unknown state.");
        }
    }

    @Override
    public void showBoard(int[][] board) {
        for (int y = 0; y < board[0].length; y++) {
            for (int x = 0; x < board.length; x++) {
                System.out.print(parseCell(board[x][y]) + "  ");
            }
            System.out.println();
        }
    }

    private String parseCell(int cellValue) {
        switch (cellValue) {
            case Board.CELL_MINE: return "*";
            case Board.CELL_FLAG: return "F";
            case Board.CELL_CLOSED: return "#";
        }
        return String.valueOf(cellValue);
    }

    @Override
    public UserInput getUserInput(int boardWidth, int boardHeight) {
        System.out.print("Enter cell X. ");
        int cellX = getNumberFromUserInRange(0, boardWidth);
        System.out.print("Enter cell Y. ");
        int cellY = getNumberFromUserInRange(0, boardHeight);
        System.out.print("Enter cell action. 0-pen or f-1-ag. ");
        int action = getNumberFromUserInList(UserInput.ACTION_OPEN, UserInput.ACTION_FLAG);
        return new UserInput(cellX, cellY, action);
    }

    /**
     * Gets a number, entered in the console
     * @param minValue the minimal valid input
     * @param maxValueExcluded the max valid input, excluding this number
     * @return the entered number
     */
    private int getNumberFromUserInRange(int minValue, int maxValueExcluded) {
        int inputNumber;
        do {
            System.out.print(String.format("Number should be from %d to %d. ", minValue, maxValueExcluded - 1));
            inputNumber = getNumberFromUser();
        } while (inputNumber < minValue || inputNumber >= maxValueExcluded);
        return inputNumber;
    }

    private int getNumberFromUserInList(int...validValues) {
        int inputNumber;
        do {
            System.out.print("Number should be valid. ");
            inputNumber = getNumberFromUser();
        } while (!isNumberInArray(inputNumber, validValues));
        return inputNumber;
    }

    private boolean isNumberInArray(int number, int[] validValues) {
        return IntStream.of(validValues).anyMatch(x -> x == number);
    }

    private int getNumberFromUser() {
        int input;
        try {
            input = new Scanner(System.in).nextInt();
        } catch (InputMismatchException exception) {
            System.out.println("Please, enter numbers only.");
            return getNumberFromUser();
        }
        return input;
    }
}
