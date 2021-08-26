package DSA.leetcode;

import static java.lang.Math.max;

public class Q714 {

    public int maxProfit(int[] prices, int fee) {

        int[] tab = new int[prices.length + 1];
        for (int i = tab.length - 2; i >= 0; i--) {

            tab[i] = tab[i+1];

            for (int j = i + 1; j < prices.length; j++) {
                tab[i] = max(
                        max(0, prices[j] - prices[i] - fee) + tab[j + 1],
                        tab[i]
                );
            }
        }
        return tab[0];

    }

    public static void main(String[] args) {
        int[] arr = {2,1,4,4,2,3,2,5,1,2};
        Q714 test = new Q714();
        System.out.println(test.maxProfit(arr, 1));

    }

}
