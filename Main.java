package tictactoe;
import java.util.*;

public class Main {
    final static Scanner scan = new Scanner(System.in);
    static String[][] board = new String[3][3];
    static int xs = 0;
    static int os = 0;

    public static void main(String[] args) {
        System.out.print("Enter cells: ");
        String[] s = scan.next().split("");
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (s[count].equals("_") == false) {
                    board[j][i] = s[count];
                } else {
                    board[j][i] = " ";
                }
                if (s[count].equals("X")) {
                    xs++;
                } else if (s[count].equals("O")) {
                    os++;
                }
                count++;
            }
        }
        printBoard();
        ask();
    }

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

    public static void ask() {
        try {
            System.out.print("Enter the coordinates: ");
            int x = scan.nextInt();
            int y = scan.nextInt();
            if (x > 3 || y > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                ask();
            } else {
                place(x, y);
            }
        } catch (Exception e) {
            System.out.println("You should enter numbers!");
            scan.nextLine();
            ask();
        }
    }

    public static void place(int x, int y) {
        x--;
        y = Math.abs(y - 3);
        if (board[x][y].equals(" ") == false) {
            System.out.println("This cell is occupied! Choose another one!");
            ask();
        } else {
            if (xs == os) {
                board[x][y] = "X";
                xs++;
            } else {
                board[x][y] = "O";
                os++;
            }
            printBoard();
            check();
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
                    System.out.println("Game not finished");
                }
                break;
            default:
                System.out.println(res + " wins");
                break;
        }
    }
}
