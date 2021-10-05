package DSA.leetcode;

import java.util.Arrays;

public class Q62 {

    public int uniquePaths(int m, int n) {

        int[] tab = new int[n];
        int[] temp = new int[n];

        Arrays.fill(tab, 1);


        for (int j = 1; j < m; j++) {

            for (int i = 0; i < n; i++) {
                if (i == 0){
                    temp[i] = 1;
                }else {
                    temp[i] = tab[i] + temp[i - 1];
                }
            }

            tab = temp;
            temp = new int[n];

        }

        return tab[n - 1];


    }


    public static void main(String[] args) {
        Q62 test = new Q62();
        System.out.println(test.uniquePaths(3, 7));
    }
}
