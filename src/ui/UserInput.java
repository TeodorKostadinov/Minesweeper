package ui;

public class UserInput {

    public static final int ACTION_OPEN = 0;
    public static final int ACTION_FLAG = 1;

    private int cellX;
    private int cellY;
    private int action;

    public UserInput(int cellX, int cellY, int action) {
        this.cellX = cellX;
        this.cellY = cellY;
        this.action = action;
    }

    public int getCellX() {
        return cellX;
    }

    public int getCellY() {
        return cellY;
    }

    public int getAction() {
        return action;
    }
}
