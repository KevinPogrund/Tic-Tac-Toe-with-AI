package tictactoe;

abstract class Player {
    protected String type;

    public Player() {

    }

    public String[][] play(String[][] b ){
        return b;
    }

    public String checkWinner(String[][] board, String p){
        for (int k = 0; k < 3; k++) {
            //check for column
            if (board[0][k].equals(board[1][k]) && board[2][k].equals(board[1][k]) && board[1][k].equals(" ") == false) {
                return board[0][k];
            }
            //check for row
            if (board[k][0].equals(board[k][1]) && board[k][2].equals(board[k][1]) && board[k][1].equals(" ") == false) {
                return board[k][0];
            }
            //check for diagonal
            if (board[0][0].equals(board[1][1]) && board[2][2].equals(board[1][1]) && board[1][1].equals(" ") == false) {
                return board[1][1];
            }
            //check other diagonal
            if (board[2][0].equals(board[1][1]) && board[0][2].equals(board[1][1]) && board[1][1].equals(" ") == false) {
                return board[1][1];
            }
            //check for blank spaces
            for (int i = 0; i < 3; i++) {
                if (board[k][i].equals(" ")) {
                    return "-";
                }
            }
        }
        return "draw";
    }

    public String getType(){
        return type;
    }

    @Override
    public String toString() {
        return "";
    }
}
