package org.example;

public class Board {
    private char[][] board = new char[3][3];

    public boolean makeMove(int row, int col, char symbol) {
        if (board[row][col] == '\0') {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }

    public void printBoard() {
        System.out.println("▁▁▁▁▁▁");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] == '\0' ? " " : board[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("▔▔▔▔");
    }

    public char[][] getBoard() {
        return board;
    }
}
