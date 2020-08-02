package tictactoe;

import java.util.*;

public class Main {
    static String[][] board = new String[3][3];
    static boolean p1;
    static Player player1;
    static Player player2;

    public static void main(String[] args) {
        start();
    }

    //print the board in the correct format
    public static void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("|\n");
        }
        System.out.println("---------");
    }

    public static void playGame() {
        printBoard();
        String res = player1.checkWinner(board);
        switch (res) {
            case "draw":
                System.out.println("Draw\n");
                start();
            case "-":
                if (p1) {
                    System.out.print(player1.toString());
                    board = player1.play(board);
                } else {
                    System.out.print(player2.toString());
                    board = player2.play(board);
                }
                p1 = !p1;
                break;
            default:
                System.out.println(res + " wins\n");
                start();
        }
        playGame();
    }

    public static void start() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input command: ");
        String[] input = scan.nextLine().split(" ");
        String inp1 = input[0];
        if (inp1.equals("exit")) {
            System.exit(0);
        }
        try {
            String p1 = input[1];
            String p2 = input[2];
            switch (inp1) {
                case "start":
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            board[i][j] = " ";//populate a blank board
                        }
                    }
                    break;
                default:
                    System.out.println("bad parameters!");
                    start();
            }
            //create player 1
            switch (p1) {
                case "user":
                    player1 = new User("X");
                    break;
                case "easy":
                    player1 = new EasyAi("X");
                    break;
                case "medium":
                    player1 = new MediumAi("X");
                    break;
                case "hard":
                    player1 = new Hardai("X");
                    break;
                default:
                    System.out.println("bad parameters!");
                    start();
            }
            //create player 2
            switch (p2) {
                case "user":
                    player2 = new User("O");
                    break;
                case "easy":
                    player2 = new EasyAi("O");
                    break;
                case "medium":
                    player2 = new MediumAi("O");
                    break;
                case "hard":
                    player2 = new Hardai("O");
                    break;
                default:
                    System.out.println("bad parameters!");
                    start();
            }
        } catch (Exception e) {
            System.out.println("bad parameters!");
            start();
        }
        printBoard();
        System.out.print(player1.toString());
        board = player1.play(board);
        p1 = false;
        playGame();
    }
}