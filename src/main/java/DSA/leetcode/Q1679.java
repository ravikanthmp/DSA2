package DSA.leetcode;

import java.util.Arrays;

public class Q1679 {

    public int maxOperations(int[] nums, int k) {

        Arrays.sort(nums);

        int total = 0;

        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int cmp = Integer.compare(nums[left] + nums[right], k);
            if (cmp == 0){
                total++;
                left++;
            }else if (cmp > 0){
                right--;
            }else {
                left++;
            }
        }
        return total;
    }

}
