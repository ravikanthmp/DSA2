package DSA.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Q283 {


    public void moveZeroes(int[] nums) {


        int i = 0;
        for (int j = 0; j < nums.length; j++)
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }

        while (i < nums.length){
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        Q283 test = new Q283();
        int[] arr = {0,1,0,3,12};
        test.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }



}
