package DSA.leetcode.topInterview.easy;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        for (int row = 0; row < board.length; row++) {

            boolean rowResult = checkRow(board, row);
            if (!rowResult){
                return false;
            }
        }

        for (int col = 0; col < board[0].length; col++) {

            boolean colResult = checkColumn(board, col);
            if (!colResult){
                return false;
            }
        }

        for (int row = 0; row < board.length; row+=3) {
            for (int col = 0; col < board[0].length; col+=3) {
                boolean res = isValid(board, row, col);
                if (!res){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int row, int col) {
        int x = 0;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (!Character.isDigit(board[i][j])){
                    continue;
                }
                int y = board[i][j] - '0';
                if ( (x & (1 << y)) != 0){
                    return false;
                }
                x = x | (1 << y);

            }
        }
        return true;
    }

    private boolean checkColumn(char[][] board, int col) {
        int x = 0;
        for (int row = 0; row < board.length; row++) {
            if (!Character.isDigit(board[row][col])){
                continue;
            }
            int y = board[row][col] - '0';
            if ( (x & (1 << y)) != 0){
                return false;
            }
            x = x | (1 << y);

        }
        return true;
    }

    private boolean checkRow(char[][] board, int row) {
        int x = 0;
        for (int col = 0; col < board[0].length; col++) {
            if (!Character.isDigit(board[row][col])){
                continue;
            }
            int y = board[row][col] - '0';
            if ( (x & (1 << y)) != 0){
                return false;
            }
            x = x | (1 << y);
        }
        return true;


    }

}
