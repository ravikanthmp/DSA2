package DSA.leetcode;

import java.util.*;

public class Q494 {


    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int i = 0;
        while (i < nums.length){

            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int sum = queue.remove();

                int curr = nums[i] ;

                queue.add(sum + curr);
                queue.add(sum - curr);
            }
            i++;
        }

        return (int) queue.stream().filter(x -> x == target).count();
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        Q494 test = new Q494();
        System.out.println(test.findTargetSumWays(nums, target));
    }
}
