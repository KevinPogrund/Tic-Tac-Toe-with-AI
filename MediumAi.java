package tictactoe;

import java.util.*;

public class MediumAi extends EasyAi {

    public MediumAi(String s) {
        super(s);
    }

    @Override
    public String[][] play(String[][] board) {
        String[][] b;
        //check the horizontals
        for (int i = 0; i < 3; i++) {
            int x = 0;
            int o = 0;
            int space = 0;
            int loc_space = 0;
            String[] a = board[i];
            for (int j = 0; j < 3; j++) {
                switch (board[i][j]) {
                    case "X":
                        x++;
                        break;
                    case "O":
                        o++;
                        break;
                    default:
                        space++;
                        loc_space = j;
                }
            }
            if ((x == 2 || o == 2) && space == 1) {
                board[i][loc_space] = type;
                return board;
            }
        }
        //check the verticals
        for (int i = 0; i < 3; i++) {
            int x = 0;
            int o = 0;
            int space = 0;
            int loc_space = 0;
            String[] a = {board[i][0], board[i][1], board[i][2]};
            for (int j = 0; j < 3; j++) {
                switch (board[j][i]) {
                    case "X":
                        x++;
                        break;
                    case "O":
                        o++;
                        break;
                    default:
                        space++;
                        loc_space = j;
                }
            }
            if ((x == 2 || o == 2) && space == 1) {
                board[loc_space][i] = type;
                return board;
            }
        }
        // check diagonals

        String[] nw = {board[0][0], board[1][1], board[2][2]};//diag from topleft to bottomright
        String[] ne = {board[2][0], board[1][1], board[0][2]};//diag from topright to bottomleft
        String[][] diagonals = {nw, ne};//array of the 2 diagonals
        for (int j = 0; j < 2; j++) {
            int x = 0;
            int o = 0;
            int space = 0;
            int loc_space = 0;
            for (int i = 0; i < 3; i++) {
                switch (diagonals[j][i]) {
                    case "X":
                        x++;
                        break;
                    case "O":
                        o++;
                        break;
                    default:
                        space++;
                        loc_space = i;
                }
                if ((x == 2 || o == 2) && space == 1) {
                    switch (j) {
                        case 0:
                            switch (loc_space) {
                                case 0:
                                    board[0][0] = type;
                                    return board;
                                case 1:
                                    board[1][1] = type;
                                    return board;
                                case 2:
                                    board[2][2] = type;
                                    return board;
                            }
                        case 1:
                            switch (loc_space) {
                                case 0:
                                    board[2][0] = type;
                                    return board;
                                case 1:
                                    board[1][1] = type;
                                    return board;
                                case 2:
                                    board[0][2] = type;
                                    return board;
                            }
                    }
                }
            }
        }
        //this runs if there is no mediumAI move
        b = super.play(board);//the random move with no print statement
        return b;
    }

    @Override
    public String toString() {
        return "Making move level \"medium\"\n";
    }
}
