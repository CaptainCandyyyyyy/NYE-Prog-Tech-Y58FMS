package hu.nye.progtech.torpedo;

import java.util.Arrays;

/**
 * Starts the game loop.
 */

public class Board {

    private TileType[][] board;
    private static final int BOARDSIZE = 10;

    public Board() {
        board = new TileType[BOARDSIZE][BOARDSIZE];
        for (int row = 0; row < BOARDSIZE; row++) {
            Arrays.fill(board[row], TileType.EMPTY);
        }
    }

    public TileType get(int x, int y) {
        return board[x][y];
    }

    public void set(int x, int y, TileType type) {
        board[x][y] = type;
    }
}
