package DSA.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q560 {

    public int subarraySum(int[] nums, int k) {
        int x = 0;
        int[] prefixSum = new int[nums.length];
        Map<Integer, Integer> prefixSumSeenSoFar = new HashMap<>();
        int runnigSum = 0;
        // prefix sum
        for (int i = 0; i < prefixSum.length; i++) {
            runnigSum+= nums[i];
            prefixSum[i] = runnigSum;
            if (prefixSum[i] == k){
                x++;
            }else {
                int diff = prefixSum[i] - k;
                x += prefixSumSeenSoFar.getOrDefault(diff, 0);
            }

            prefixSumSeenSoFar.put(
                    prefixSum[i],
                    prefixSumSeenSoFar.getOrDefault(prefixSum[i], 0) + 1
            );
        }
        return x;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        int k = 3;
        Q560 test = new Q560();
        System.out.println(test.subarraySum(a, k));
    }

}
