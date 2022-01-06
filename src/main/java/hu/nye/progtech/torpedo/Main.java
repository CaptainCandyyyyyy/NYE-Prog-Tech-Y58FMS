package hu.nye.progtech.torpedo;


import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Starts the game loop.
 */

public class Main {
    IGameResultService gameResultService;
    public Main(IGameResultService gameResultService) {
        this.gameResultService = gameResultService;
    }

    /**
     * Starts the game loop.
     */

    public void main(String[] args) {
        String playerName = "";
        Scanner input = new Scanner(System.in);

        System.out.println("Whats your name? :");
        playerName = input.nextLine();

        System.out.println("Would you like to play(1) or check the leaderboard(2)?");
        int wish = input.nextInt();
        if (wish == 2) {
                showLeaderboard();
        }

        Board playerBoard = new Board();
        Board computerBoard = new Board();
        GameBoard gameBoard = new GameBoard(playerBoard, computerBoard);
        BattleShipsGame game = new BattleShipsGame(gameBoard);

        System.out.println("You have a 5 tile long, 2 4 tile long, 3 3 tile long and 4 2 tile long ships," +
                " You must place them before the game begins.");
        System.out.println("Please enter the starting coordinates(1-10) and the direction(0 for right,1 for down," +
                "2 for left,3 for up) of your ships and the length of them.");
        /*for (int i = 0; i < 10; i++) {
            System.out.println("First coordinate:");
            int x = input.nextInt() - 1;
            System.out.println("Second coordinate:");
            int y = input.nextInt() - 1;
            System.out.println("Direction:");
            int dir = input.nextInt();
            System.out.println("Length:");
            int length = input.nextInt();
            BoardPopulator.placePlayerBoard(x, y, dir, length, game.getGameBoard().PlayerBoard());
            game.printPlayerBoard();
        }
        */
        BoardPopulator.placeComputerBoard(game.getGameBoard().playerBoard());

        BoardPopulator.placeComputerBoard(game.getGameBoard().computerBoard());


        while (game.isInProgress()) {
            //  int x = input.nextInt()-1;
            //  int y = input.nextInt()-1;
            int x = ThreadLocalRandom.current().nextInt(0, 10);
            int y = ThreadLocalRandom.current().nextInt(0, 10);
            game.takeTurn(x, y);
            game.printPlayerBoard();
            game.printComputerBoard();
            x = ThreadLocalRandom.current().nextInt(0, 10);
            y = ThreadLocalRandom.current().nextInt(0, 10);
            game.takeTurn(x, y);
        }

        if (game.getWinner() == Player.PLAYER) {
            System.out.println("Congrats, YOU WON!");
            this.gameResultService.create(playerName, true);
        } else {
            System.out.println("YOU LOST!");
            this.gameResultService.create(playerName, false);
        }
    }

    /**
     * Starts the game loop.
     */

    public  void showLeaderboard() {
        for (GameResult r:
             this.gameResultService.listAll()) {
            System.out.println(r.getPlayerName() + ": " + r.isWinner());
        }
    }
}


