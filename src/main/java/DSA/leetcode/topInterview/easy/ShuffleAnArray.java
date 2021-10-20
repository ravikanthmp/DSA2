package DSA.leetcode.topInterview.easy;

import java.util.Arrays;

public class ShuffleAnArray {


    class Solution {

        private int[] nums;
        private int[] shuffle;

        public Solution(int[] nums) {
            this.nums = nums;
            shuffle = nums.clone();
        }

        public int[] reset() {
            shuffle = nums.clone();
            return shuffle;
        }

        public int[] shuffle() {
            for (int i = 1; i < nums.length; i++) {
                int j = nums.length % i;
                exch(nums, i, (int) (Math.random() * j));
            }
            return shuffle;
        }

        private void exch(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
