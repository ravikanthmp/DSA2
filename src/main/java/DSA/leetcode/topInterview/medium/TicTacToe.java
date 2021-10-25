package DSA.leetcode.topInterview.medium;

class TicTacToe {

    char[][] board;

    public TicTacToe(int n) {

        board = new char[n][n];

    }

    public int move(int row, int col, int player) {
        board[row][col] = (player == 1) ? 'X' : 'O';
        return isDone(row, col, player) ? player : 0;
    }

    private boolean isDone(int row, int col, int player){

        char lookingFor = (player == 1) ? 'X' : 'O';

        boolean res = checkCol(col, lookingFor) || checkRow(row, lookingFor) || checkDiag(lookingFor);
        return res;
    }

    private boolean checkRow(int row, char lookingFor){
        // row
        for (int n = 0; n < board[0].length; n++) {
            if (board[row][n] != lookingFor){
                return false;
            }
        }
        return true;
    }

    private boolean checkCol(int col, char lookingFor){
        for (int m = 0; m < board.length; m++) {
            if (board[m][col] != lookingFor){
                return false;
            }
        }
        return true;
    }

    private boolean checkDiag(char lookingFor){
        boolean ans = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] != lookingFor){
                ans = false;
                break;
            }
        }


        if (!ans){
            for (int i = 0; i < board.length; i++) {
                if (board[i][board[0].length - 1 - i] != lookingFor){
                    return false;
                }
            }

        }

        return true;
    }
}
