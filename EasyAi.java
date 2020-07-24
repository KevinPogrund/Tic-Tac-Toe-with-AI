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
}
