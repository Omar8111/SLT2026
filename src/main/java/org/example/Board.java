package org.example;

public class Board {
    private char[][] cells = new char[3][3];

    public Board() {
        clear();
    }

    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == '\0';
    }

    public void place(int x, int y, char marker) {
        cells[x][y] = marker;
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = '\0';
            }
        }
    }

    public void print() {
        System.out.println("▁▁▁▁▁▁▁▁");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[i][j] == '\0' ? " " : cells[i][j]);
                System.out.print(" | ");
            }
            System.out.println();
        }
        System.out.println("▔▔▔▔▔▔▔");
    }

    public char[][] getCells() {
        return cells;
    }
}