package hu.nye.progtech.torpedo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

    class GameBoardTests {

        @Test
        void ShootShouldReturnTileType() {
            GameBoard gameBoard = new GameBoard();
            TileType result = gameBoard.Shoot(Player.PLAYER,0,0);
            assertTrue(result != null);
        }
        @Test
        void PLayerBoardShouldNotBeNull() {
            GameBoard gameBoard = new GameBoard();
            assertTrue(gameBoard.PlayerBoard() != null);
        }
        @Test
        void ComputerBoardShouldNotBeNull() {
            GameBoard gameBoard = new GameBoard();
            assertTrue(gameBoard.ComputerBoard() != null);
        }
    }
