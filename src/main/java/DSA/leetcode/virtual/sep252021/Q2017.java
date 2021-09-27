package DSA.leetcode.virtual.sep252021;

import java.util.Arrays;

public class Q2017 {

    private int[][] grid;

    public long gridGame(int[][] grid) {
        this.grid = grid;

        int[][] memo = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                memo[i][j] = grid[i][j] + Math.max(val(i, j - 1, memo), val(i - 1, j, memo));
            }
        }

        int i = memo.length - 1;
        int j = memo[0].length - 1;
        while ((i != 0) || (j != 0)) {
            if (memo[i][j] == grid[i][j] + val(i, j - 1, memo)) {
                grid[i][j] = 0;
                j = j - 1;
            } else {
                grid[i][j] = 0;
                i = i - 1;
            }

        }

        grid[i][j] = 0;


        memo = new int[grid.length][grid[0].length];
        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j++) {
                memo[i][j] = grid[i][j] + Math.max(val(i, j - 1, memo), val(i - 1, j, memo));
            }
        }
        return memo[grid.length - 1][grid[0].length - 1];
    }

    private boolean isValid(int row, int col, int[][] arr) {
        return (row >= 0 && row < arr.length) && (col >= 0 && col < arr[0].length);
    }

    private int val(int row, int col, int[][] arr) {
        if (isValid(row, col, arr)) {
            return arr[row][col];
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {20, 3, 20, 17, 2, 12, 15, 17, 4, 15},
                {20, 10, 13, 14, 15, 5, 2, 3, 14, 3}
        };
        Q2017 test = new Q2017();
        System.out.println(test.gridGame(arr));
        int[] a2 = {20, 10, 13, 14, 15, 5, 2, 3, 14, 0};
        System.out.println(Arrays.stream(a2).sum());
    }
}
