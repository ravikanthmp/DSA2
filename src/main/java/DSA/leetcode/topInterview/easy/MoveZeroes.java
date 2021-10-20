package DSA.leetcode.topInterview.easy;

import java.util.Arrays;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int count = (int) Arrays.stream(nums)
                .filter(x -> x == 0)
                .count();

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0){
                nums[i++] = 0;
            }
        }

        for (int j = i; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

}
