package hu.nye.progtech.torpedo;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Starts the game loop.
 */

public class BoardPopulator {

    /**
     * Starts the game loop.
     */

    public static void placePlayerBoard(int x, int y, int dir, int length, Board board) {

        boolean canplace = true;
        int xmodifier = 0;
        int ymodifier = 0;
        switch (dir) {
            case 0:
                xmodifier = 1;
                break;
            case 1:
                ymodifier = 1;
                break;
            case 2:
                xmodifier = -1;
                break;
            case 3:
                ymodifier = -1;
                break;
            default:
                break;
        }
        for (int i = 0; i < length; i++) {
            if (x + (xmodifier * i) > 9 || x + (xmodifier * i) < 0 || (y + (ymodifier * i)) > 9 || y + (ymodifier * i) < 0) {
                canplace = false;
                System.out.println("Wrong input!");
                break;
            }

            if (board.get(x + (xmodifier * i), y + (ymodifier * i)) != TileType.EMPTY) {
                canplace = false;
                System.out.println("Wrong input!");
            }
        }
        if (canplace) {
            for (int i = 0; i < length; i++) {
                board.set(x + (xmodifier * i), y + (ymodifier * i), TileType.SHIP);
            }
        }
    }

    /**
     * Starts the game loop.
     */

    public static void placeComputerBoard(Board board) {
        int[] ships = new int[]{5, 4, 4, 3, 3, 3, 2, 2, 2, 2};
        int counter = 0;

        while (counter != 10) {
            int x = ThreadLocalRandom.current().nextInt(0, 10);
            int y = ThreadLocalRandom.current().nextInt(0, 10);
            int dir = ThreadLocalRandom.current().nextInt(0, 4);

            boolean canplace = true;
            int xmodifier = 0;
            int ymodifier = 0;
            switch (dir) {
                case 0:
                    xmodifier = 1;
                    break;
                case 1:
                    ymodifier = 1;
                    break;
                case 2:
                    xmodifier = -1;
                    break;
                case 3:
                    ymodifier = -1;
                    break;
                default:
                    break;
            }

            for (int i = 0; i < ships[counter]; i++) {

                if (x + (xmodifier * i) > 9 || x + (xmodifier * i) < 0 || (y + (ymodifier * i)) > 9 || y + (ymodifier * i) < 0) {
                    canplace = false;
                    break;
                }

                if (board.get(x + (xmodifier * i), y + (ymodifier * i)) != TileType.EMPTY) {
                    canplace = false;
                }
            }

            if (canplace) {
                for (int i = 0; i < ships[counter]; i++) {
                    board.set(x + (xmodifier * i), y + (ymodifier * i), TileType.SHIP);
                }
                counter++;
            }
        }
    }
}
