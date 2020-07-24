package tictactoe;

import java.util.*;

public class User extends Player {

    public User(String t) {
        super();
        this.type = t;
    }

    public String[][] play(String[][] board) {
        int[] loc = getInput(board);
        board[loc[1]][loc[0]] = type;
        return board;
    }

    public static int[] getInput(String[][] board) {
        Scanner s = new Scanner(System.in);
        try {
            System.out.print("Enter the coordinates: ");
            int x = s.nextInt();
            int y = s.nextInt();
            if (x > 3 || y > 3) {//checks the range of the input
                System.out.println("Coordinates should be from 1 to 3!");
                int[] loop = getInput(board);
                return loop;
            } else {
                x--;
                y = 3 - y;//converts the user input into how the board is mapped in the array
                if (board[y][x].equals(" ") == false) {
                    System.out.println("This cell is occupied! Choose another one!");
                    int[] loop = getInput(board);
                    return loop;
                } else {
                    int[] ret = {x, y};
                    return ret;
                }
            }
        } catch (Exception e) {
            System.out.println("You should enter numbers!");
            //s.nextLine();//NB - stops a continuous loop
            getInput(board);
        }

       /* int[] r = new int[]{1, 1};
        return r;*/
        return null;
    }

}
