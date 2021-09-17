package DSA.leetcode;

import java.util.Arrays;

public class Q189 {

    public void rotate(int[] nums, int l) {
        int k = nums.length - l;
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int lo, int hi){
        while (lo < hi){
            exch(nums, lo++, hi--);
        }
    }

    private void exch(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Q189 test = new Q189();
        int[] arr = {1,2,3,4,5,6,7};
        int k = 3;
        test.rotate(arr, k);
        System.out.println(Arrays.toString(arr));
    }
}
