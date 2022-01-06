package hu.nye.progtech.torpedo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BoardPopulatorTests {


    @Test
    void PLayerBoardShouldFillUpBoard() {
        Board playerBoard = new Board();
        Board computerBoard = new Board();
        GameBoard gameBoard = new GameBoard(playerBoard, computerBoard);
        BattleShipsGame game = new BattleShipsGame(gameBoard);
        BoardPopulator.placePlayerBoard(0, 1, 1, 2, playerBoard);
        assertTrue(playerBoard.get(0, 1) == TileType.SHIP);
    }

    @Test
    void ComputerBoardShouldFillUpBoard() {
        Board playerBoard = new Board();
        Board computerBoard = new Board();
        GameBoard gameBoard = new GameBoard(playerBoard, computerBoard);
        BattleShipsGame game = new BattleShipsGame(gameBoard);
        BoardPopulator.placeComputerBoard(computerBoard);
        int counter = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (computerBoard.get(i, j) == TileType.SHIP) {
                    counter++;
                }
            }

        }
        assertTrue(counter == 30);
    }
}