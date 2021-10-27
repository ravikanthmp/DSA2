package DSA.leetcode.topInterview.hard;

import java.util.Arrays;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {

        boolean contaisnOne = Arrays.stream(nums).anyMatch(x -> x == 1);

        if (!contaisnOne){
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0){
                nums[i] = 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
           if (Math.abs(nums[i]) < nums.length){
               if (nums[Math.abs(nums[i])] > 0){
                   nums[Math.abs(nums[i])] *= -1;
               }

           }
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0){
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        FirstMissingPositive test = new FirstMissingPositive();
        int[] arr = {1};
        System.out.println(test.firstMissingPositive(arr));
    }
}
