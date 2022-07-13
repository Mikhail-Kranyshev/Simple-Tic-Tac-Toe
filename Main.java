package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        char[] game = scanner.next().toCharArray();
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
}
