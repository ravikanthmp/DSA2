package DSA.leetcode.topInterview.easy;

import java.util.Arrays;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] temp = Arrays.copyOf(nums, nums.length);
        int j = 0;

        for (int i = k; i < nums.length; i++) {
            nums[i] = temp[j++];
        }

        int l = 0;
        for (int i = j; i < nums.length; i++) {
            nums[l++] = temp[i];
        }

    }

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] arr = {1,2,3,4,5,6,7};
        int k = 3;
        rotateArray.rotate(arr, k);
        System.out.println(Arrays.toString(arr));
    }

}
