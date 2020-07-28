package tictactoe;
import java.util.*;

public class EasyAi extends Player {

    public EasyAi(String t) {
        super();
        this.type = t;
    }

    public String[][] play(String[][] board){
        Random r = new Random();
        int x = r.nextInt(3);
        int y = r.nextInt(3);
        if (board[y][x].equals(" ")) {//checks if it is a blank space
            board[y][x] = type;
            System.out.println("Making move level \"easy\"");
           /* try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            return board;
        } else {
           play(board);
        }
        return board;
    }
//this is for when it is called by medium a1 (copy and pasted, added int for overloading)
    public String[][] play(String[][] board, int k){
        Random r = new Random();
        int x = r.nextInt(3);
        int y = r.nextInt(3);
        if (board[y][x].equals(" ")) {//checks if it is a blank space
            board[y][x] = type;
           /* try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            return board;
        } else {
            play(board);
        }
        return board;
    }
}
