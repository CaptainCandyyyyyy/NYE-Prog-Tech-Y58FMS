package hu.nye.progtech.torpedo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class BattleShipsGameTests {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream(); //https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void IsInProgressShouldReturnTrue() {
        Board playerBoard = new Board();
        Board computerBoard = new Board();
        GameBoard gameBoard = new GameBoard(playerBoard, computerBoard);
        BattleShipsGame game = new BattleShipsGame(gameBoard);
        assertTrue(game.IsInProgress());
    }
    @Test
    void TakeTurnShouldReturnTileType() {
        Board playerBoard = new Board();
        Board computerBoard = new Board();
        GameBoard gameBoard = new GameBoard(playerBoard, computerBoard);
        BattleShipsGame game = new BattleShipsGame(gameBoard);
        TileType result = game.TakeTurn(0, 0);
        assertTrue(result != null);
    }
    @Test
    void printPLayerBoardReturns() {
        Board playerBoard = new Board();
        Board computerBoard = new Board();
        GameBoard gameBoard = new GameBoard(playerBoard, computerBoard);
        BattleShipsGame game = new BattleShipsGame(gameBoard);
        game.printPlayerBoard();
        assertTrue(!outContent.toString().equals("") );
    }
    @Test
    void printComputerBoardReturns() {
        Board playerBoard = new Board();
        Board computerBoard = new Board();
        GameBoard gameBoard = new GameBoard(playerBoard, computerBoard);
        BattleShipsGame game = new BattleShipsGame(gameBoard);
        game.printComputerBoard();
        assertTrue(!outContent.toString().equals("") );
    }
}
