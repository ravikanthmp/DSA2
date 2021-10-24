package DSA.leetcode.topInterview.medium;

import java.util.Arrays;

public class SortColors {

    public void sortColors(int[] nums) {

        int[] count = new int[3];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int from = 0;
        int to = 0;

        for (int i = 0; i < count.length; i++) {
            to += count[i];
            Arrays.fill(nums, from, to, i);
            from = to;
        }

    }

}
