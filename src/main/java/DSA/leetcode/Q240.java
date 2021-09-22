package DSA.leetcode;

public class Q240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int M = matrix.length;
        int N = matrix[0].length;

        int row = M - 1;
        int col = 0;

        while (true){
            if (row < 0 || col == N){
                return false;
            }

            int cmp = Integer.compare(matrix[row][col], target);
            if (cmp == 0){
                return true;
            }else if (cmp < 0){
                col++;
            }else {
                row--;
            }
        }
    }

}
