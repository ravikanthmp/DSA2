package DSA.leetcode;

import java.util.Arrays;

public class Q300 {

    public int lengthOfLIS(int[] nums) {

        int[] tab = new int[nums.length + 1];
        Arrays.fill(tab, 1);
        int maxSoFar = 1;
        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    tab[i] = Math.max(tab[i], 1 + tab[j]);
                }
            }

            maxSoFar = Math.max(maxSoFar, tab[i]);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        Q300 test = new Q300();
        int[] arr = {0,1,0,3,2,3};
        System.out.println(test.lengthOfLIS(arr));
    }

}
