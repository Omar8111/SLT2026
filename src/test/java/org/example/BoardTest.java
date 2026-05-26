package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    // isCellEmpty Tests
    @Test
    public void testIsCellEmpty_emptyCell_returnsTrue() {
        // Arrange
        Board board = new Board();
        // Act
        boolean result = board.isCellEmpty(0, 0);
        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsCellEmpty_occupiedCell_returnsFalse() {
        // Arrange
        Board board = new Board();
        // Act
        board.place(0, 0, 'X');
        boolean result = board.isCellEmpty(0, 0);
        // Assert
        assertFalse(result);
    }

    // place Tests
    @Test
    public void testPlace_placeX_cellOccupied() {
        // Arrange
        Board board = new Board();
        // Act
        board.place(0, 0, 'X');
        // Assert
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    public void testPlace_placeO_cellOccupied() {
        // Arrange
        Board board = new Board();
        // Act
        board.place(1, 1, 'O');
        // Assert
        assertFalse(board.isCellEmpty(1, 1));
    }

    // isFull Tests
    @Test
    public void testIsFull_emptyBoard_returnsFalse() {
        // Arrange
        Board board = new Board();
        // Act
        boolean result = board.isFull();
        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsFull_fullBoard_returnsTrue() {
        // Arrange
        Board board = new Board();
        // Act
        board.place(0, 0, 'X');
        board.place(0, 1, 'O');
        board.place(0, 2, 'X');
        board.place(1, 0, 'O');
        board.place(1, 1, 'X');
        board.place(1, 2, 'O');
        board.place(2, 0, 'X');
        board.place(2, 1, 'O');
        board.place(2, 2, 'X');
        boolean result = board.isFull();
        // Assert
        assertTrue(result);
    }

    // clear Tests
    @Test
    public void testClear_afterPlace_cellEmpty() {
        // Arrange
        Board board = new Board();
        board.place(0, 0, 'X');
        // Act
        board.clear();
        // Assert
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    public void testClear_fullBoard_isEmpty() {
        // Arrange
        Board board = new Board();
        board.place(0, 0, 'X');
        board.place(1, 1, 'O');
        // Act
        board.clear();
        // Assert
        assertFalse(board.isFull());
    }
}
