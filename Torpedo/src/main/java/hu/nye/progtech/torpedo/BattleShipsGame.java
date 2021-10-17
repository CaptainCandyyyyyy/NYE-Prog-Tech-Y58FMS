package hu.nye.progtech.torpedo;

import java.util.Random;

public class BattleShipsGame {
    private GameBoard gameBoard;
    private Player currentPlayer;
    private Player winner;


    public BattleShipsGame() {
        winner = null;



        Random rand = new Random();
        int startingPlayer = rand.nextInt(2);

        if (startingPlayer == 0 ) {
            currentPlayer = Player.PLAYER;
        } else {
            currentPlayer = Player.COMPUTER;
        }

        gameBoard = new GameBoard();
    }

    public void printBoard(){
        Board boardToprint;
        Board board = currentPlayer == Player.PLAYER ? gameBoard.ComputerBoard() : gameBoard.PlayerBoard();
        for(int row = 0; row < 10; row++)
        {
            for(int col = 0; col < 10; col++){
                char sign;
                TileType state = board.Get(row, col);
                switch(state){
                    case EMPTY:
                        sign = ' ';
                        break;
                    case HIT:
                        sign = 'H';
                        break;
                    case MISS:
                        sign = 'M';
                        break;
                    case SHIP:
                        sign = 'S';
                        break;
                    default:
                        sign = 'e';
                        break;
                }
                System.out.print("|" + sign);

            }
            System.out.print("|");
            System.out.println();
        }

    }
    public boolean IsInProgress(){
        return winner == null;
    }

    public Player GetWinner(){
        return winner;
    }

    public TileType TakeTurn(int x, int y) {
        var result = gameBoard.Shoot(currentPlayer, x, y);

        currentPlayer = (currentPlayer == Player.PLAYER) ? Player.COMPUTER : Player.PLAYER;
        CheckWinner();

        return result;
    }


    private void CheckWinner() {
        var board = currentPlayer == Player.PLAYER ? gameBoard.ComputerBoard() : gameBoard.PlayerBoard();

        boolean gameOver = true;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board.Get(i,j) == TileType.SHIP ) {
                    gameOver = false;
                    break;
                }
            }
            if (!gameOver) {
                break;
            }
        }

        if (gameOver) {
            winner = currentPlayer;
        }
    }
}
