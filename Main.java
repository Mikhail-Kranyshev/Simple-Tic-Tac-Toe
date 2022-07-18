package tictactoe;

import java.util.Scanner;

public class Main {
    public static boolean status(char[][] matrix){
        char[] win = {' ', ' '};
        for (int i = 0; i < 3; i++) {
            if ((matrix[i][0] == 'X' &&
                    matrix[i][1] == 'X' &&
                    matrix[i][2] == 'X') ||
                    (matrix[i][0] == 'O' &&
                    matrix[i][1] == 'O' &&
                    matrix[i][2] == 'O'))  {
                System.out.println(matrix[i][0] + " wins");
                return true;
            }
            if ((matrix[0][i] == 'X' &&
                    matrix[1][i] == 'X' &&
                    matrix[2][i] == 'X') ||
                    (matrix[0][i] == 'O' &&
                            matrix[1][i] == 'O' &&
                            matrix[2][i] == 'O'))  {
                System.out.println(matrix[0][i] + " wins");
                return true;
            }
        }
        if ((matrix[0][0] == 'X' && matrix[1][1] == 'X' && matrix[2][2] == 'X') ||
                (matrix[0][2] == 'X' && matrix[1][1] == 'X' && matrix[2][0] == 'X') ||
                (matrix[0][0] == 'O' && matrix[1][1] == 'O' && matrix[2][2] == 'O') ||
                (matrix[0][2] == 'O' && matrix[1][1] == 'O' && matrix[2][0] == 'O')) {
            System.out.println(matrix[1][1] + " wins");
            return true;
        }
        return false;
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


    public static char[][] generate() {
        char[][] matrix = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = ' ';
            }
        }
        return matrix;
    }


    public static char[][] inputCoordinates(char[][] matrix, char elem){
        int x = 0, y = 0;
        do {
            Scanner sc2 = new Scanner(System.in);
            if (sc2.hasNextInt()) {
                x = sc2.nextInt();
                if (sc2.hasNextInt()) {
                    y = sc2.nextInt();
                    if (0 < x && x < 4 && 0 < y && y < 4) {
                        if (matrix[x - 1][y - 1] == ' ') {
                            matrix[x - 1][y - 1] = elem;
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
        char[][] game = generate();
        char[] XO = {'X', 'O'};
        boolean gameOver = false;
        printGame(game);
        for (int i = 0; i < 9; i++){
            game = inputCoordinates(game, XO[i % 2]);
            printGame(game);
            if (status(game)) break;
            else if (i == 8) System.out.println("Draw");
        }
    }
}
