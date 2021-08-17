package DSA.leetcode;

import java.util.Arrays;

public class Q62 {

    private int[][] tab;
    private int M;
    private int N;

    public int uniquePaths(int m, int n) {
        this.M = m;
        this.N = n;
        tab = new int[m + 1][n + 1];
        tab[m][n] = 1;
        Arrays.fill(tab[M], 1, N, 1);

        for (int i = M - 1; i >= 1 ; i--) {
            for (int j = N; j >= 1 ; j--) {
                if (i == M && j == N){
                    tab[i][j] = 1;
                }else {
                    tab[i][j] = unique(i, j + 1) + unique(i + 1, j);
                }

            }
        }
        return tab[1][1];
    }

    private int unique(int i, int j){
        if (i == 0 || j == 0 || i > M || j > N){
            return 0;
        }else {
            return tab[i][j];
        }
    }

    public static void main(String[] args) {
        Q62 test = new Q62();
        System.out.println(test.uniquePaths(3, 7));
    }
}
