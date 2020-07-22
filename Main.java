package tictactoe;

import java.util.*;

public class Main {
    final static Scanner scan = new Scanner(System.in);
    static String[][] board = new String[3][3];
    static boolean user = true;//this detmines if it is the user or computer turn


    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[j][i] = " ";//populate a blank board
            }
        }
        printBoard();
        userInput();
    }

    //print the board in the correct format
    public static void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[j][i] + " ");
            }
            System.out.print("|\n");
        }
        System.out.println("---------");
    }

    //ask for the user input
    public static void userInput() {
        try {
            System.out.print("Enter the coordinates: ");
            int x = scan.nextInt();
            int y = scan.nextInt();
            if (x > 3 || y > 3) {//checks the range of the input
                System.out.println("Coordinates should be from 1 to 3!");
                userInput();
            } else {
                user = false; //makes the next turn a computer turn
                x--;
                y = Math.abs(y - 3);//converts the user input into how the board is mapped in the array
                if (board[x][y].equals(" ") == false) {
                    System.out.println("This cell is occupied! Choose another one!");
                    userInput();
                } else {
                    board[x][y] = "X";
                    printBoard();
                    check();
                }
            }
        } catch (Exception e) {
            System.out.println("You should enter numbers!");
            scan.nextLine();//NB - stops a continuous loop
            userInput();
        }
    }


    public static void check() {
        String res = "-";
        boolean done = true;
        for (int k = 0; k < 3; k++) {
            //check for column
            if (board[0][k].equals(board[1][k]) && board[2][k].equals(board[1][k]) && board[1][k].equals(" ") == false) {
                res = board[0][k];
                break;
            }
            //check for row
            if (board[k][0].equals(board[k][1]) && board[k][2].equals(board[k][1]) && board[k][1].equals(" ") == false) {
                res = board[k][0];
                break;
            }
            //check for diagonal
            if (board[0][0].equals(board[1][1]) && board[2][2].equals(board[1][1]) && board[1][1].equals(" ") == false) {
                res = board[1][1];
                break;
            }
            //check other diagonal
            if (board[2][0].equals(board[1][1]) && board[0][2].equals(board[1][1]) && board[1][1].equals(" ") == false) {
                res = board[1][1];
                break;
            }
            //check for blank spaces
            for (int i = 0; i < 3; i++) {
                if (board[k][i].equals(" ")) {
                    done = false;
                }
            }
        }

        switch (res) {
            case "-":
                if (done) {
                    System.out.println("Draw");
                } else {
                    if (user) {
                        userInput();
                    } else {
                        easy_play();
                    }
                }
                break;
            default:
                System.out.println(res + " wins");
                break;
        }
    }

    public static void easy_play() {
        Random r = new Random();
        int x = r.nextInt(3);
        int y = r.nextInt(3);
        if (board[y][x].equals(" ")) {//checks if it is a blank space
            board[y][x] = "O";
            System.out.println("Making move level \"easy\"");
            printBoard();
            user = true;
            check();
        } else {
            easy_play();
        }
    }
}