package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {
        @Test
        public void testHasWinner_rowWin_returnsTrue() {
            // Arrange
            Board board = new Board();
            board.place(0, 0, 'X');
            board.place(0, 1, 'X');
            board.place(0, 2, 'X');
            // Act
            boolean result = checkWinner(board, 'X');
            // Assert
            assertTrue(result);
        }

        @Test
        public void testHasWinner_noWin_returnsFalse() {
            // Arrange
            Board board = new Board();
            board.place(0, 0, 'X');
            board.place(1, 1, 'O');
            // Act
            boolean result = checkWinner(board, 'X');
            // Assert
            assertFalse(result);
        }

        @Test
        public void testHasWinner_columnWin_returnsTrue() {
            // Arrange
            Board board = new Board();
            board.place(0, 0, 'X');
            board.place(1, 0, 'X');
            board.place(2, 0, 'X');
            // Act
            boolean result = checkWinner(board, 'X');
            // Assert
            assertTrue(result);
        }

        @Test
        public void testHasWinner_diagonalWin_returnsTrue() {
            // Arrange
            Board board = new Board();
            board.place(0, 0, 'X');
            board.place(1, 1, 'X');
            board.place(2, 2, 'X');
            // Act
            boolean result = checkWinner(board, 'X');
            // Assert
            assertTrue(result);
        }

        // Hilfsmethode
        private boolean checkWinner(Board board, char marker) {
            char[][] c = board.getCells();
            for (int i = 0; i < 3; i++) {
                if (c[i][0] == marker && c[i][1] == marker && c[i][2] == marker) return true;
            }
            for (int j = 0; j < 3; j++) {
                if (c[0][j] == marker && c[1][j] == marker && c[2][j] == marker) return true;
            }
            if (c[0][0] == marker && c[1][1] == marker && c[2][2] == marker) return true;
            if (c[0][2] == marker && c[1][1] == marker && c[2][0] == marker) return true;
            return false;
        }
    }
