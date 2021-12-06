package hu.nye.progtech.torpedo;

import java.util.Random;

public class BattleShipsGame {
    public GameBoard getGameBoard() {
        return gameBoard;
    }

    private GameBoard gameBoard;
    private Player currentPlayer;
    private Player winner;


    public BattleShipsGame(GameBoard gameboard) {
        winner = null;
        currentPlayer = Player.PLAYER;
        this.gameBoard = gameboard;
    }

    public void printPlayerBoard(){
        Board boardToprint;
        Board board = gameBoard.PlayerBoard();

        System.out.print("  ");
        for (int i = 0; i < 10; i++) {
            System.out.print(' ');
            System.out.print(i+1);
        }
        System.out.println();
        for(int row = 0; row < 10; row++) {
            if (row == 9){
                System.out.print(row+1);
            }
            else{
                System.out.print(' ');
                System.out.print(row+1);
            }
            for(int col = 0; col < 10; col++){
                char sign;
                TileType state = board.Get(col, row);
                switch(state){
                    case EMPTY:
                        sign = ' ';
                        break;
                    case HIT:
                        sign = 'X';
                        break;
                    case MISS:
                        sign = 'O';
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
    public void printComputerBoard(){
        Board boardToprint;
        Board board = gameBoard.ComputerBoard();

        System.out.print("  ");
        for (int i = 0; i < 10; i++) {
            System.out.print(' ');
            System.out.print(i+1);
        }
        System.out.println();
        for(int row = 0; row < 10; row++) {
            if (row == 9){
                System.out.print(row+1);
            }
            else{
                System.out.print(' ');
                System.out.print(row+1);
            }
            for(int col = 0; col < 10; col++){
                char sign;
                TileType state = board.Get(col, row);
                switch(state){
                    case EMPTY:
                        sign = ' ';
                        break;
                    case HIT:
                        sign = 'X';
                        break;
                    case MISS:
                        sign = 'O';
                        break;
                    case SHIP:
                        sign = ' ';
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
