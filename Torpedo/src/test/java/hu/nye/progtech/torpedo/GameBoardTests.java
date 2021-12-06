package hu.nye.progtech.torpedo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

    class GameBoardTests {

        @Test
        void ShootShouldReturnTileType() {
            Board playerBoard = new Board();
            Board computerBoard = new Board();
            GameBoard gameBoard = new GameBoard(playerBoard, computerBoard);
            TileType result = gameBoard.Shoot(Player.PLAYER,0,0);
            assertTrue(result != null);
        }
        @Test
        void PLayerBoardShouldNotBeNull() {
            Board playerBoard = new Board();
            Board computerBoard = new Board();
            GameBoard gameBoard = new GameBoard(playerBoard, computerBoard);
            assertTrue(gameBoard.PlayerBoard() != null);
        }
        @Test
        void ComputerBoardShouldNotBeNull() {
            Board playerBoard = new Board();
            Board computerBoard = new Board();
            GameBoard gameBoard = new GameBoard(playerBoard, computerBoard);
            assertTrue(gameBoard.ComputerBoard() != null);
        }
    }
