package DSA.leetcode;

import java.util.Arrays;

public class Q62 {
    public int uniquePaths(int m, int n) {

        int[] tab = new int[n];

        Arrays.fill(tab, 1);

        for(int row = 1; row < m; row++){

            int prev = 0;
            for (int i = 0; i < n ; i++) {

                if(i == 0){
                    tab[i] = 1;
                }else{
                    tab[i] += prev;
                }
                prev = tab[i];
            }
        }


        return tab[n-1];
    }

    public static void main(String[] args) {
        Q62 test = new Q62();
        System.out.println(test.uniquePaths(3, 7));
    }
}
