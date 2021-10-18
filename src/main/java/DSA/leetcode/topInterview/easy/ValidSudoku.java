package DSA.leetcode.topInterview.easy;

import java.util.HashSet;
import java.util.Set;

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
        Set<Character> seen = new HashSet<>();
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (seen.contains(board[i][j])){
                    return false;
                }
                if (Character.isDigit(board[i][j])){
                    seen.add(board[i][j]);
                }

            }
        }
        return true;
    }

    private boolean checkColumn(char[][] board, int col) {

        Set<Character> seen = new HashSet<>();
        for (int row = 0; row < board.length; row++) {
            if (seen.contains(board[row][col])){
                return false;
            }
            if (Character.isDigit(board[row][col])){
                seen.add(board[row][col]);
            }

        }
        return true;
    }

    private boolean checkRow(char[][] board, int row) {
        Set<Character> seen = new HashSet<>();
        for (int col = 0; col < board[0].length; col++) {
            if (seen.contains(board[row][col])){
                return false;
            }
            if (Character.isDigit(board[row][col])){
                seen.add(board[row][col]);
            }
        }
        return true;


    }

}
