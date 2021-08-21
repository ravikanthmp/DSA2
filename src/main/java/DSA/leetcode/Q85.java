package DSA.leetcode;

public class Q85 {

    int[][] tab ;

    public int maximalRectangle(char[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        tab = new int[M][N];

        for (int row = 0; row < M; row++) {
            for (int col = 0; col < N; col++) {
                if (matrix[row][col] == '1'){
                    tab[row][col] = 1;
                }
            }
        }

        return 0;
    }

}
