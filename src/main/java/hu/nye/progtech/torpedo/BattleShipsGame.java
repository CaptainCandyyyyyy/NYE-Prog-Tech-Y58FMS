package hu.nye.progtech.torpedo;

/**
 * Starts the game loop.
 */

public class BattleShipsGame {
    private GameBoard gameBoard;
    private Player currentPlayer;
    private Player winner;

    public BattleShipsGame(GameBoard gameboard) {
        winner = null;
        currentPlayer = Player.PLAYER;
        this.gameBoard = gameboard;
    }

    /**
     * Starts the game loop.
     */

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    /**
     * Starts the game loop.
     */

    public void printPlayerBoard() {
        Board boardToprint;
        Board board = gameBoard.playerBoard();

        System.out.print("  ");
        for (int i = 0; i < 10; i++) {
            System.out.print(' ');
            System.out.print(i + 1);
        }
        System.out.println();
        for (int row = 0; row < 10; row++) {
            if (row == 9) {
                System.out.print(row + 1);
            } else {
                System.out.print(' ');
                System.out.print(row + 1);
            }
            for (int col = 0; col < 10; col++) {
                char sign;
                TileType state = board.get(col, row);
                switch (state) {
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

    /**
     * Starts the game loop.
     */

    public void printComputerBoard() {
        Board boardToprint;
        Board board = gameBoard.computerBoard();

        System.out.print("  ");
        for (int i = 0; i < 10; i++) {
            System.out.print(' ');
            System.out.print(i + 1);
        }
        System.out.println();
        for (int row = 0; row < 10; row++) {
            if (row == 9) {
                System.out.print(row + 1);
            } else {
                System.out.print(' ');
                System.out.print(row + 1);
            }
            for (int col = 0; col < 10; col++) {
                char sign;
                TileType state = board.get(col, row);
                switch (state) {
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

    public boolean isInProgress() {
        return winner == null;
    }

    public Player getWinner() {
        return winner;
    }

    /**
     * Starts the game loop.
     */

    public TileType takeTurn(int x, int y) {
        var result = gameBoard.shoot(currentPlayer, x, y);

        currentPlayer = (currentPlayer == Player.PLAYER) ? Player.COMPUTER : Player.PLAYER;
        checkWinner();

        return result;
    }


    private void checkWinner() {
        var board = currentPlayer == Player.PLAYER ? gameBoard.computerBoard() : gameBoard.playerBoard();

        boolean gameOver = true;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board.get(i, j) == TileType.SHIP) {
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
