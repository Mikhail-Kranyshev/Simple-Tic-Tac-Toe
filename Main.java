package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static String status(char[][] game){
        char[] win = {'_', '_'};
        for (int i = 0; i < 3; i++) {
            if ((game[i][0] == 'X' &&
                    game[i][1] == 'X' &&
                    game[i][2] == 'X') ||
                    (game[i][0] == 'O' &&
                    game[i][1] == 'O' &&
                    game[i][2] == 'O'))  {
                if (win[0] == '_') {
                    win[0] = game[i][0];
                } else {
                    win[1] = game[i][0];
                }
            }
            if ((game[0][i] == 'X' &&
                    game[1][i] == 'X' &&
                    game[2][i] == 'X') ||
                    (game[0][i] == 'O' &&
                            game[1][i] == 'O' &&
                            game[2][i] == 'O'))  {
                if (win[0] == '_') {
                    win[0] = game[0][i];
                } else {
                    win[1] = game[0][i];
                }
            }
        }
        if ((game[0][0] == 'X' && game[1][1] == 'X' && game[2][2] == 'X') ||
                (game[0][2] == 'X' && game[1][1] == 'X' && game[2][0] == 'X') ||
                (game[0][0] == 'O' && game[1][1] == 'O' && game[2][2] == 'O') ||
                (game[0][2] == 'O' && game[1][1] == 'O' && game[2][0] == 'O')) {
            return game[1][1] + " wins";
        }
        int countX = 0, countO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (game[i][j] == 'X') {
                    countX++;
                } else if (game[i][j] == 'O') {
                    countO++;
                }
            }
        }
        if (Math.abs(countX - countO) >= 2 || win[1] != '_') {
            return "Impossible";
        } else if (win[0] != '_') {
            return win[0] + " wins";
        }
        if ((countX == 4 && countO == 5) || (countX == 5 && countO == 4)) {
            return "Draw";
        }
        return "Game not finished";
    }


    public static void printGame(char[][] game) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++){
            System.out.print("| ");
            for (int j = 0; j < 3; j++){
                System.out.printf("%c ", game[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }


    public static char[][] inputGame(Scanner sc) {
        System.out.print("Enter cells: ");
        char[] tmp = sc.next().toCharArray();
        char[][] matrix = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = tmp[i * 3 + j];
            }
        }
        return matrix;
    }


    public static char[][] inputCoordinates(char[][] matrix){
        int x = 0, y = 0;
        do {
            Scanner sc2 = new Scanner(System.in);
            System.out.print("Enter the coordinates: ");
            if (sc2.hasNextInt()) {
                x = sc2.nextInt();
                if (sc2.hasNextInt()) {
                    y = sc2.nextInt();
                    if (0 < x && x < 4 && 0 < y && y < 4) {
                        if (matrix[x - 1][y - 1] == '_') {
                            matrix[x - 1][y - 1] = 'X';
                            break;
                        } else {
                            System.out.println("This cell is occupied! Choose another one!");
                        }

                    } else {
                        System.out.println("Coordinates should be from 1 to 3!");
                    }
                }
                continue;
            }
            System.out.println("You should enter numbers!");
        } while (x > 1 || x < 3 || y > 1 || y < 3);
        return matrix;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] game = inputGame(scanner);
        printGame(game);
        game = inputCoordinates(game);
        printGame(game);
//        System.out.println(status(game));
    }
}
