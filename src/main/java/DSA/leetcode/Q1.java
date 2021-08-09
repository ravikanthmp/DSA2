package DSA.leetcode;

import java.util.*;

public class Q1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] soln = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                soln[0] = map.get(target - nums[i]);
                soln[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return soln;
    }


    public static void main(String[] args) {
        Q1 twoSum = new Q1();
        int[] arr = {3, 2, 4};
        int target = 6;
        int[] ints = twoSum.twoSum(arr, target);
        System.out.println(Arrays.toString(ints));
    }
}
