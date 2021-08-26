package DSA.leetcode;

import java.util.Arrays;

public class Q309 {

    int[] memo;

    public int maxProfit(int[] prices) {

        if (prices.length < 2){
            return 0;
        }

        int[] max = max(prices);
        memo = new int[prices.length];
        Arrays.fill(memo, -1);
        int ans = maxProfit(prices, 0, max);
        return ans;

    }

    private int maxProfit(int[] prices, int idx, int[] max) {
            if (idx > prices.length - 1){
                return 0;
            }else {

                int saved = memo[idx];
                int res = 0;
                if (saved == -1){
                    res = Math.max(maxProfit(prices, idx + 1, max), res);
                    for (int i = idx + 1; i <= prices.length - 1 ; i++) {
                        res = Math.max(res,
                                prices[i] - prices[idx] + maxProfit(prices, i + 2, max));
                    }
                    memo[idx] = res;
                }

                return memo[idx];
            }
    }

    private int[] max(int[] prices) {
        int maxProfitSoFar = 0;
        int maxPriceSoFar = prices[prices.length - 1];
        int[] max = new int[prices.length];
        for (int i = prices.length - 2; i >= 0; i--) {
            maxProfitSoFar = Math.max(maxProfitSoFar, maxPriceSoFar - prices[i]);
            max[i] = maxProfitSoFar;
            maxPriceSoFar = Math.max(maxPriceSoFar, prices[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        Q309 test = new Q309();
        System.out.println(test.maxProfit(prices));
    }

}
