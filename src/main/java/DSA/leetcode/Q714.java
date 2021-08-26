package DSA.leetcode;

public class Q714 {

    public int maxProfit(int[] prices, int fee) {
        int[] f = new int[prices.length];
        f[0] = 0;
        int runningMax = Integer.MIN_VALUE;
        for (int i = 1; i < f.length; i++) {
            runningMax = Math.max(runningMax, f[i - 1] - prices[i - 1]);
            f[i] = Math.max(f[i - 1], runningMax + prices[i] - fee);
        }
        return f[prices.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = {1,3};
        Q714 test = new Q714();
        System.out.println(test.maxProfit(arr, 2));

    }

}
