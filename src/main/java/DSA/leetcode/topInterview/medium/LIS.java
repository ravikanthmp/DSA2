package DSA.leetcode.topInterview.medium;

import java.util.Arrays;

public class LIS {


    public int lengthOfLIS(int[] nums) {
        int max = 1;
        int[] tab = new int[nums.length];
        Arrays.fill(tab, 1);

        for (int i = 1; i < nums.length; i++) {

            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i]){
                    tab[i] = Math.max(tab[i], 1 + tab[j]);
                }
            }

            max = Math.max(max, tab[i]);
        }

        return max;
    }

}
