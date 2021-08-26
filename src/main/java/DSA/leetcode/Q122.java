package DSA.leetcode;

import java.util.Arrays;

public class Q122 {

    int[] memo;

    public int maxProfit(int[] prices) {
        int[] max = max(prices);
        memo = new int[prices.length];
        memo[prices.length - 1] = 0;
        Arrays.fill(memo, -1);
        return f(0, prices, memo);
    }

    private int f(int idx, int[] prices, int[] memo){
        if (idx >= prices.length - 1){
            return 0;
        }else {
            int res = memo[idx];
            if (res == -1 ){
                int ans = f(idx + 1, prices, memo);
                for (int sellIdx = idx + 1; sellIdx < prices.length; sellIdx++) {
                    ans = Math.max(
                            ans,
                            prices[sellIdx] - prices[idx] + f(sellIdx + 1, prices, memo)
                    );
                }
                memo[idx] = ans;
                return memo[idx];
            }else {
                return res;
            }
        }
    }

    private int[] max(int[] prices) {
        int N = prices.length;
        int[] maxProfit = new int[prices.length];
        maxProfit[prices.length - 1] = 0;
        int maxProfitSoFar = 0;
        int maxPriceSoFar = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            maxProfitSoFar = Math.max(maxProfitSoFar, maxPriceSoFar - prices[i]);
            maxProfit[i] = maxProfitSoFar;
            maxPriceSoFar = Math.max(maxPriceSoFar, prices[i]);
        }
        return maxProfit;
    }

}
