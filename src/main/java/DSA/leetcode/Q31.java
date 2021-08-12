package DSA.leetcode;

import java.util.Arrays;

public class Q31 {

    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        int ptr = nums.length - 2;

        while (ptr >= 0 && nums[ptr] >= nums[ptr + 1]) {
            ptr--;
        }

        if (ptr < 0) {
            reverse(nums);
        } else {
            int j = nums.length - 1;
            while (nums[j] <= nums[ptr]){
                j--;
            }
            exch(nums, ptr, j);
            reverse(nums, ptr + 1, nums.length - 1);
        }
    }

    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums) {
       reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int lo, int hi) {
        int i = lo;
        int j = hi;
        while (i < j){
            exch(nums, i, j);
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        Q31 test = new Q31();
        int[] arr = {1, 3, 2};
        test.nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
