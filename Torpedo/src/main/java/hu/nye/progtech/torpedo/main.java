package hu.nye.progtech.torpedo;

import java.util.Scanner;

public class main {


    public static void main(String[] args) {
        String playerName = "";
        Scanner input = new Scanner(System.in);

        System.out.println("Whats your name? :");
        playerName = input.nextLine();
        BattleShipsGame game = new BattleShipsGame();

        //TODO Setup board;

        while (game.IsInProgress()) {
            int x = input.nextInt();
            int y = input.nextInt();
            var resutl = game.TakeTurn(x,y);

        game.printBoard();
        }

        if (game.GetWinner() == Player.PLAYER){
            System.out.println("Gratulálok számitógép de ezt most én nyertem!");
        } else {
            System.out.println("EZ");
        }
    }
}
