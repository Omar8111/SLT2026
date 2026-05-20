package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Current Player: " + game.getCurrentPlayer().getSymbol());
            game.getBoard().printBoard();

            System.out.print("row (0-2): ");
            int row = scanner.nextInt();
            System.out.print("column (0-2): ");
            int col = scanner.nextInt();

            boolean validMove = game.getBoard().makeMove(row, col, game.getCurrentPlayer().getSymbol());
            if (validMove) {
                game.switchPlayer();
            } else {
                System.out.println("Feld bereits belegt! Nochmal versuchen!");
            }
        }
    }
}