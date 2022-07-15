package tictactoe;

import java.util.Scanner;

public class Main {
    public static String status(char[] game){
        char[] win = {'_', '_'};
        for (int i = 0; i < 3; i++) {
            if ((game[i * 3] == 'X' &&
                    game[i * 3 + 1] == 'X' &&
                    game[i * 3 + 2] == 'X') ||
                    (game[i * 3] == 'O' &&
                    game[i * 3 + 1] == 'O' &&
                    game[i * 3 + 2] == 'O'))  {
                if (win[0] == '_') {
                    win[0] = game[i * 3];
                } else {
                    win[1] = game[i * 3];
                }
            }
            if ((game[i] == 'X' &&
                    game[i + 3] == 'X' &&
                    game[i + 6] == 'X') ||
                    (game[i] == 'O' &&
                            game[i + 3] == 'O' &&
                            game[i + 6] == 'O'))  {
                if (win[0] == '_') {
                    win[0] = game[i];
                } else {
                    win[1] = game[i];
                }
            }
        }
        if ((game[0] == 'X' && game[4] == 'X' && game[8] == 'X') ||
                (game[2] == 'X' && game[4] == 'X' && game[6] == 'X') ||
                (game[0] == 'O' && game[4] == 'O' && game[8] == 'O') ||
                (game[2] == 'O' && game[4] == 'O' && game[6] == 'O')) {
            return game[4] + " wins";
        }
        int countX = 0, countO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (game[i * 3 + j] == 'X') {
                    countX++;
                } else if (game[i * 3 + j] == 'O') {
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


    public static void printGame(char[] game) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++){
            System.out.print("| ");
            for (int j = 0; j < 3; j++){
                System.out.printf("%c ", game[i * 3 + j]);
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        char[] game = scanner.next().toCharArray();
        printGame(game);
        System.out.println(status(game));

    }
}
