package DSA.leetcode;

import java.util.*;

public class Q1 {
    public int[] twoSum(int[] nums, int target) {
        // Reverse Map
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new LinkedList<Integer>());
            }
            map.get(nums[i]).add(i);
        }

        Arrays.sort(nums);

        int[] soln = new int[2];
        int left = 0;
        int right = nums.length - 1;
        boolean found = false;
        while (left < right && !found){
            int sum = nums[left] + nums[right];
            if (sum == target){
                soln = getIndices(nums[left], nums[right], map);
                found = true;
            }else if (sum < target){
                left++;
            }else {
                right--;
            }
        }
        return soln;
    }

    private int[] getIndices(int num1, int num2, Map<Integer, List<Integer>> map){
        int[] soln = new int[2];
        if (num1 == num2){
            List<Integer> list = map.get(num1);
            soln[0] = list.get(0);
            soln[1] = list.get(1);
        }else {
            soln[0] = map.get(num1).get(0);
            soln[1] = map.get(num2).get(0);
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
