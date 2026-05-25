package org.example;

import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Current Player: " + currentPlayer.getMarker());
            board.print();

            System.out.print("row (0-2): ");
            int x = scanner.nextInt();
            System.out.print("column (0-2): ");
            int y = scanner.nextInt();

            if (x < 0 || x > 2 || y < 0 || y > 2) {
                System.out.println("Ungültige Eingabe! Nur 0-2 erlaubt!");
                continue;
            }


            if (board.isCellEmpty(x, y)) {
                board.place(x, y, currentPlayer.getMarker());

                if (hasWinner()) {
                    board.print();
                    System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                    System.out.println("Player " + (currentPlayer == player1 ? player2.getMarker() : player1.getMarker()) + " loses!");
                    break;
                }

                if (board.isFull()) {
                    board.print();
                    System.out.println("It's a Draw! No winner this time.");
                    break;
                }

                switchCurrentPlayer();
            } else {
                System.out.println("Feld bereits belegt! Nochmal versuchen!");
            }
        }
    }

    private void switchCurrentPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    private boolean hasWinner() {
        char[][] c = board.getCells();
        char m = currentPlayer.getMarker();

        // Reihen
        for (int i = 0; i < 3; i++) {
            if (c[i][0] == m && c[i][1] == m && c[i][2] == m) return true;
        }

        // Spalten
        for (int j = 0; j < 3; j++) {
            if (c[0][j] == m && c[1][j] == m && c[2][j] == m) return true;
        }

        // Diagonalen
        if (c[0][0] == m && c[1][1] == m && c[2][2] == m) return true;
        if (c[0][2] == m && c[1][1] == m && c[2][0] == m) return true;

        return false;
    }
}