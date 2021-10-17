package hu.nye.progtech.torpedo;

import java.util.Arrays;

public class Board {

    private TileType[][] board;
    private int BOARD_SIZE = 10;

    public Board() {
        board = new TileType[BOARD_SIZE][BOARD_SIZE];
        for (int row = 0; row < BOARD_SIZE; row++) {
        Arrays.fill(board[row],TileType.EMPTY);
        }
    }

    public TileType Get(int x, int y) {
        return board[x][y];
    }

    public void Set(int x, int y, TileType type) {
        board[x][y] = type;
    }
}
