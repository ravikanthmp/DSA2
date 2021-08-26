package DSA.leetcode;

public class Q714 {

    public int maxProfit(int[] prices, int fee) {
        int[] f = new int[prices.length];
        f[prices.length - 1] = 0;
        int maxSumSoFar = 0;
        for (int i = f.length - 2; i >= 0; i--) {
            maxSumSoFar = Math.max(maxSumSoFar, f[i + 1] + prices[i + 1]);
            f[i] = Math.max(f[i+1], maxSumSoFar - prices[i] - fee);
        }
        return f[0];
    }

    public static void main(String[] args) {
        int[] arr = {1, 3};
        Q714 test = new Q714();
        System.out.println(test.maxProfit(arr, 2));

    }

}
