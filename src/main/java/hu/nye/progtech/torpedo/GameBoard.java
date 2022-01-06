package hu.nye.progtech.torpedo;

/**
 * Starts the game loop.
 */

public class GameBoard {

    private Board playerBoard;
    private Board computerBoard;

    public GameBoard(Board playerBoard, Board computerBoard) {
        this.playerBoard = playerBoard;
        this.computerBoard = computerBoard;
    }

    public Board playerBoard() {
        return playerBoard;
    }

    public Board computerBoard() {
        return computerBoard;
    }

    /**
     * Starts the game loop.
     */

    public TileType shoot(Player currentPlayer, int x, int y) {
        Board board = currentPlayer == Player.PLAYER ? computerBoard() : playerBoard();
        update(board, x, y);

        return board.get(x, y);
    }

    private void update(Board board, int x, int y) {
        board.set(x, y, board.get(x, y) == TileType.SHIP || board.get(x, y) == TileType.HIT ? TileType.HIT : TileType.MISS);
    }
}
