package DSA.leetcode.topInterview.easy;

public class StocksBuyAndSell {

    public int maxProfit(int[] prices) {
        int maxPriceSoFar = prices[prices.length - 1];
        int maxProfitSoFar = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            maxProfitSoFar = Math.max(maxProfitSoFar, maxPriceSoFar - prices[i]);
            maxPriceSoFar = Math.max(maxPriceSoFar, prices[i]);
        }
        return maxProfitSoFar;
    }

}
