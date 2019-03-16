package core;

public class Game {

    public static final int GAME_WON = 1;
    public static final int GAME_LOST = 2;
    public static final int GAME_ACTIVE = 3;

    public Game(int boardWidth, int boardHeight, int mineCount) {
        //TODO
    }

    public boolean isActive() {
        return getResult() == GAME_ACTIVE;
    }

    public int getResult() {
        //TODO
        return GAME_ACTIVE;
    }
}
