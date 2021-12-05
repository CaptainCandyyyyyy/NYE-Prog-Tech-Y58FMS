package hu.nye.progtech.torpedo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class BoardPopulatorTests {


    @Test
    void PLayerBoardShouldFillUpBoard() {
        BattleShipsGame game = new BattleShipsGame();
        Board playerBoard = game.getGameBoard().PlayerBoard();
        BoardPopulator.placePlayerBoard(0,1,1,2, playerBoard);
        assertTrue(playerBoard.Get(0,1) == TileType.SHIP);
    }
    @Test
    void ComputerBoardShouldFillUpBoard() {
        BattleShipsGame game = new BattleShipsGame();
        Board computerBoard = game.getGameBoard().ComputerBoard();
        BoardPopulator.placeComputerBoard(computerBoard);
        int counter = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (computerBoard.Get(i,j) == TileType.SHIP){
                    counter++;
                }
            }

        }
        assertTrue(counter == 30);
    }
}