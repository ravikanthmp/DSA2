package DSA.leetcode;

import java.util.*;

public class Q1 {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (map.containsKey(target - x )){
                if (map.get(target - x) != i){
                    ans[0] = i;
                    ans[1] = map.get(target - x);
                    return ans;
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        Q1 twoSum = new Q1();
        int[] arr = {3, 2, 4};
        int target = 6;
        int[] ints = twoSum.twoSum(arr, target);
        System.out.println(Arrays.toString(ints));
    }
}
