package tictactoe;

import java.util.*;

public class Main {
    static String[][] board = new String[3][3];
    static int user;
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
                    System.out.println("Draw\n");
                    start();
                } else {
                    if (user == 1) {
                        board = player1.play(board);
                        user = 2;
                    } else {
                        board = player2.play(board);
                        user = 1;
                    }
                }
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
            if(inp1.equals("exit")){
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
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("bad parameters!");
                    start();
            }

            //create player 1
            switch (p1){
                case "user":
                    player1 = new User("X");
                    break;
                case "easy":
                    player1 = new EasyAi("X");
                    break;
                case "medium":
                    player1 = new MediumAi("X");
                    break;
                default:
                    System.out.println("bad parameters!");
                    start();
            }
            //create player 2
            switch (p2){
                case "user":
                    player2 = new User("O");
                    break;
                case "easy":
                    player2 = new EasyAi("O");
                    break;
                case "medium":
                    player2 = new MediumAi("O");
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
        board = player1.play(board);
        user = 2;
        playGame();
    }

    /*
    //ai for level easy
    public static void easy_play() {
        Random r = new Random();
        int x = r.nextInt(3);
        int y = r.nextInt(3);
        if (board[y][x].equals(" ")) {//checks if it is a blank space
            board[y][x] = "O";
            System.out.println("Making move level \"easy\"");
            printBoard();
            user = 1;
            check();
        } else {
            easy_play();
        }
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
                user = 2; //makes the next turn a computer turn
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
*/

}