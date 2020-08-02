package tictactoe;

public class Hardai extends Player {
    String notType;

    public Hardai(String s) {
        super();
        this.type = s;
        //this is specifically for the "min" part of minimax
        if (s.equals("X")) {
            this.notType = "O";
        } else {
            this.notType = "X";
        }
    }

    @Override
    public String[][] play(String[][] board) {
        int[] bestMove = new int[2];
        int bestScore = -100;
        //Start off the minimax algorithm and storing the best move
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals(" ")) {
                    board[i][j] = type;
                    int score = miniMax(board, false);
                    board[i][j] = " ";//reset the board before the next loop
                    if (score > bestScore) {
                        //change the best score and move
                        bestScore = score;
                        bestMove = new int[]{i, j};
                    }
                }
            }
        }
        board[bestMove[0]][bestMove[1]] = type;
        return board;
    }

    public int miniMax(String[][] board, boolean maxing) {
        String res = super.checkWinner(board);
        if (res.equals(type)) {//check if the game is finished and return value
            return 1;//win
        } else if (res.equals(notType)) {
            return -1;//lose
        } else if (res.equals("draw")) {
            return 0;
        } else {
            //if the game isn't finished, check the next move (all possible next moves)
            int bestScore;
            if (maxing) {
                bestScore = -100;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[i][j].equals(" ")) {
                            board[i][j] = type;
                            int score = miniMax(board, false);//run for opponent move so not maximising
                            board[i][j] = " ";
                            bestScore = Math.max(score, bestScore);//maximising score
                        }
                    }
                }
            } else {
                bestScore = 100;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[i][j].equals(" ")) {
                            board[i][j] = notType;
                            int score = miniMax(board, true);//run for ai so now maximising
                            board[i][j] = " ";
                            bestScore = Math.min(score, bestScore);//minimising score
                        }
                    }
                }
            }
            return bestScore;
        }
    }

    @Override
    public String toString() {
        return "Making move level \"hard\"\n";
    }
}
