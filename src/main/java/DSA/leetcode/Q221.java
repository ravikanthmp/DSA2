package DSA.leetcode;

import java.util.Arrays;

public class Q221 {
    boolean[][] tab ;

    public int maximalSquare(char[][] matrix) {
        int maxSoFar = 0;
        int M = matrix.length;
        int N = matrix[0].length;
        tab = new boolean[M][N];
        // init
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                tab[i][j] = matrix[i][j] != '0';
                if (tab[i][j]){
                    maxSoFar = 1;
                }
            }
        }

        for (int square = 2; square <= Math.min(M, N) ; square++) {

            for (int row = square - 1; row < M; row++) {
                for (int col = square - 1; col < N; col++) {
                    if (matrix[row][col] == '1' && tab[row -1][col] && tab[row - 1][col - 1] && tab[row][col - 1]){
                        tab[row][col] = true;
                        maxSoFar = Math.max(maxSoFar, square);
                    }else {
                        tab[row][col] = false;
                    }
                }
            }
        }

        return maxSoFar * maxSoFar;
    }

    public static void main(String[] args) {
        Q221 test = new Q221();
        char[][] c = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(test.maximalSquare(c));
    }

}
