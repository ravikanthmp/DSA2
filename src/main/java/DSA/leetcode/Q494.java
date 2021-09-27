package DSA.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Q494 {

    static class Pair{
        int idx;
        int sum;

        Pair(int idx, int sum) {

            this.idx = idx;
            this.sum = sum;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return idx == pair.idx && sum == pair.sum;
        }

        @Override
        public int hashCode() {
            return Objects.hash(idx, sum);
        }

        static Pair of(int idx, int sum){
            return new Pair(idx, sum);
        }
    }

    private Map<Pair, Integer> memo;
    private int sum;
    private int[] nums;
    private int target;

    public int findTargetSumWays(int[] nums, int target) {
        this.sum = Arrays.stream(nums).sum();
        this.nums = nums;
        this.target = target;
        memo = new HashMap<>();
        return test(0, 0);
    }

    private int test(int x, int idx){
        if (x > sum){
            return 0;
        }
        if (idx == nums.length){
            return (x == target) ? 1 : 0;
        }else {
            Pair pair = Pair.of(idx, x);
            if (!memo.containsKey(pair)){
                memo.put(pair,  test(x + nums[idx], idx + 1) + test(x - nums[idx], idx + 1));
            }
            return memo.get(pair);

        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        Q494 test = new Q494();
        System.out.println(test.findTargetSumWays(nums, target));
    }
}
