package hu.nye.progtech.torpedo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class main {

    public static void main(String[] args) {
        String playerName = "";
        Scanner input = new Scanner(System.in);

        System.out.println("Whats your name? :");
        playerName = input.nextLine();
        BattleShipsGame game = new BattleShipsGame();

        System.out.println("You have a 5 tile long, 2 4 tile long, 3 3 tile long and 4 2 tile long ships, You must place them before the game begins.");
        System.out.println("Please enter the starting coordinates(1-10) and the direction(0 for right,1 for down,2 for left,3 for up) of your ships and the length of them.");
        for (int i = 0; i < 10; i++) {
            System.out.println("First coordinate:");
            int x = input.nextInt() - 1;
            System.out.println("Second coordinate:");
            int y = input.nextInt() - 1;
            System.out.println("Direction:");
            int dir = input.nextInt();
            System.out.println("Length:");
            int length = input.nextInt();
        //    placeComputerBoard( game.getGameBoard().PlayerBoard());
            BoardPopulator.placePlayerBoard(x, y, dir, length, game.getGameBoard().PlayerBoard());
            game.printPlayerBoard();
        }

        BoardPopulator.placeComputerBoard( game.getGameBoard().ComputerBoard());


        while (game.IsInProgress()) {
            int x = input.nextInt()-1;
            int y = input.nextInt()-1;
            game.TakeTurn(x,y);
            game.printPlayerBoard();
            game.printComputerBoard();
            x = ThreadLocalRandom.current().nextInt(0, 10);
            y = ThreadLocalRandom.current().nextInt(0, 10);
            game.TakeTurn(x,y);
        }

        if (game.GetWinner() == Player.PLAYER){
            System.out.println("Congrats, YOU WON!");
        } else {
            System.out.println("YOU LOST!");
        }
    }
}
