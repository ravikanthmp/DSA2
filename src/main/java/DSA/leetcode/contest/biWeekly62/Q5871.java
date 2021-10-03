package DSA.leetcode.contest.biWeekly62;

import java.util.Arrays;

public class Q5871 {

    public int[][] construct2DArray(int[] original, int m, int n) {

        if (original.length != m * n){
            return new int[0][0];
        }else {
            int[][] arr = new int[m][n];

            for (int i = 0; i < m; i++) {
                arr[i] = Arrays.copyOfRange(original, i*n, (i+1)*n);
            }
            return arr;
        }
    }

    public static void main(String[] args) {
        Q5871 test = new Q5871();
        int[] orig = {3};
        int m = 1;
        int n = 2;
        int[][] ints = test.construct2DArray(orig, m, n);
        for (int[] arr : ints) {
            System.out.println(Arrays.toString(arr));
        }
    }

}
