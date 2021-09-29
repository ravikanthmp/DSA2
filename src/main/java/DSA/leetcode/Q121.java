package DSA.leetcode;

public class Q121 {
    public int maxProfit(int[] prices) {
        int maxSoFar = prices[prices.length - 1];
        int maxProfit = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            maxProfit = Math.max(maxProfit, maxSoFar - prices[i]);
            maxSoFar = Math.max(maxSoFar, prices[i]);
        }
        return maxProfit;
    }
}
