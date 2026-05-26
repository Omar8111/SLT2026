package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    @Test
    public void testGetMarker_playerX_returnsX() {
        // Arrange
        Player player = new Player('X');
        // Act
        char result = player.getMarker();
        // Assert
        assertEquals('X', result);
    }

    @Test
    public void testGetMarker_playerO_returnsO() {
        // Arrange
        Player player = new Player('O');
        // Act
        char result = player.getMarker();
        // Assert
        assertEquals('O', result);
    }

    @Test
    public void testGetMarker_playerX_notO() {
        // Arrange
        Player player = new Player('X');
        // Act
        char result = player.getMarker();
        // Assert
        assertNotEquals('O', result);
    }
}
