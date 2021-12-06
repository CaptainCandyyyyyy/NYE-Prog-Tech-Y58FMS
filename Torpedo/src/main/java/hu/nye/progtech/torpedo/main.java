package hu.nye.progtech.torpedo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class main {

    public static void main(String[] args) {
        String playerName = "";
        Scanner input = new Scanner(System.in);

        System.out.println("Whats your name? :");
        playerName = input.nextLine();

        System.out.println("Would you like to play(1) or check the leaderboard(2)?");
        int wish = input.nextInt();
        if (wish == 2){
            try {
                showLeaderboard();
            }
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        Board playerBoard = new Board();
        Board computerBoard = new Board();
        GameBoard gameBoard = new GameBoard(playerBoard, computerBoard);
        BattleShipsGame game = new BattleShipsGame(gameBoard);

        System.out.println("You have a 5 tile long, 2 4 tile long, 3 3 tile long and 4 2 tile long ships, You must place them before the game begins.");
        System.out.println("Please enter the starting coordinates(1-10) and the direction(0 for right,1 for down,2 for left,3 for up) of your ships and the length of them.");
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
        BoardPopulator.placeComputerBoard( game.getGameBoard().PlayerBoard());

        BoardPopulator.placeComputerBoard( game.getGameBoard().ComputerBoard());


        while (game.IsInProgress()) {
          //  int x = input.nextInt()-1;
          //  int y = input.nextInt()-1;
            int x = ThreadLocalRandom.current().nextInt(0, 10);
            int y = ThreadLocalRandom.current().nextInt(0, 10);
            game.TakeTurn(x,y);
            game.printPlayerBoard();
            game.printComputerBoard();
            x = ThreadLocalRandom.current().nextInt(0, 10);
            y = ThreadLocalRandom.current().nextInt(0, 10);
            game.TakeTurn(x,y);
        }

        if (game.GetWinner() == Player.PLAYER){
            System.out.println("Congrats, YOU WON!");
            try {
                FileWriter myWriter = new FileWriter("D:\\Leaderboard.csv", true);
                myWriter.write(playerName+",");
                myWriter.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        } else {
            System.out.println("YOU LOST!");
        }
    }

    public static void showLeaderboard() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("D:\\Leaderboard.csv"));
        sc.useDelimiter(",");
        while (sc.hasNext()) {
            String[] leaderboard = sc.next().split(",");
            Arrays.stream(leaderboard)
                    .collect(Collectors.groupingBy(s -> s))
                    .forEach((k, v) -> System.out.println(k+" "+v.size()));
        }
        sc.close();

    }
}

