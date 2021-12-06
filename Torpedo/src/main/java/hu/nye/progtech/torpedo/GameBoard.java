package hu.nye.progtech.torpedo;

public class GameBoard {

    private Board playerBoard;
    private Board computerBoard;

    public GameBoard(Board playerBoard, Board computerBoard) {
        this.playerBoard = playerBoard;
        this.computerBoard = computerBoard;
    }

    public Board PlayerBoard() {
        return playerBoard;
    }

    public Board ComputerBoard() {
        return computerBoard;
    }

    public TileType Shoot(Player currentPlayer, int x, int y){
        Board board = currentPlayer == Player.PLAYER ? ComputerBoard() : PlayerBoard();
        Update(board, x, y);

        return board.Get(x,y);
    }

    private void Update(Board board, int x, int y) {
            board.Set(x,y, board.Get(x,y) == TileType.SHIP || board.Get(x,y) == TileType.HIT ? TileType.HIT : TileType.MISS );
    }
}
