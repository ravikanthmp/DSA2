package DSA.leetcode.topInterview.medium;

import java.util.Arrays;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        boolean shouldClearFirstRow = Arrays.stream(matrix[0]).anyMatch(x -> x == 0);

        boolean shouldClearFirstColumn = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0){
                shouldClearFirstColumn = true;
                break;
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0){
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0){
                setColToZero(matrix, i);
            }
        }

        for (int row = 1; row < matrix.length; row++) {
            if (matrix[row][0] == 0){
                setRowToZero(matrix, row);
            }
        }

        if (shouldClearFirstColumn){
            setColToZero(matrix, 0);
        }

        if (shouldClearFirstRow){
            setRowToZero(matrix ,0);
        }
    }

    private void setRowToZero(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    private void setColToZero(int[][] matrix, int col) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][col] = 0;
        }
    }

}
