package DSA.leetcode;

public class Q64 {
    public int minPathSum(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int[] tab = new int[N];

        //init
        tab[0] = grid[0][0];
        for (int i = 1; i < N; i++) {
            tab[i] = tab[i - 1] + grid[0][i];
        }

        for (int row = 1; row < M; row++) {

            for (int col = 0; col < N; col++) {

                if (col == 0){
                    tab[col] = grid[row][col] + tab[col];
                }else {
                    tab[col] = Math.min(tab[col], tab[col -1]) + grid[row][col];
                }
            }
        }

        return tab[N - 1];
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        Q64 test = new Q64();
        System.out.println(test.minPathSum(arr));
    }

}
