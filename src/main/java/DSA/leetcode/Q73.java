package DSA.leetcode;

import java.util.Arrays;

public class Q73 {

    public void setZeroes(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {

                if (matrix[row][col] == 0) {

                    // set col marker to 0
                    matrix[0][col] = 0;

                    // set row marker to 0
                    matrix[row][0] = 0;
                }
            }
        }


        for (int row = 1; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                for (int col = 1; col < matrix[0].length; col++) {
                    matrix[row][col] = 0;
                }
            }
        }


        for (int col = 1; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) {
                for (int row = 1; row < matrix.length; row++) {
                    matrix[row][col] = 0;
                }
            }
        }

        boolean setZeroRow = false;
        for (int col = 0; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) {
                setZeroRow = true;
                break;
            }
        }

        boolean setZeroCol = false;
        for(int row = 0; row < matrix.length; row++){
            if (matrix[row][0] == 0){
                setZeroCol = true;
                break;
            }
        }

        if (setZeroCol){
            for(int row = 0; row < matrix.length; row++){
                matrix[row][0] = 0;
            }
        }

        if (setZeroRow){

            Arrays.fill(matrix[0], 0);
        }
    }

    public static void main(String[] args) {
        Q73 test = new Q73();
        int[][] arr = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        test.setZeroes(arr);
        System.out.println(Arrays.deepToString(arr));
    }
}
