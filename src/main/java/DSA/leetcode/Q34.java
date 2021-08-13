package DSA.leetcode;

import java.util.Arrays;

public class Q34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {
                binSearchLeft(nums, 0, nums.length - 1, target),
                binSearchRight(nums, 0, nums.length - 1, target)
        };
        return res;

    }

    private int binSearchLeft(int[] nums,int lo, int hi, int target){
        int res = -1;
        while (lo <= hi){
            int mid = lo + (hi - lo)/2;
            if (nums[mid] == target){
                res = mid;
                hi = mid - 1;
            }else if (target < nums[mid]){
                hi = mid - 1;
            }else {
                lo = mid + 1;
            }
        }
        return res;
    }

    private int binSearchRight(int[] nums,int lo, int hi, int target){
        int res = -1;
        while (lo <= hi){
            int mid = lo + (hi - lo)/2;
            if (nums[mid] == target){
                res = mid;
                lo = mid + 1;
            }else if (target < nums[mid]){
                hi = mid - 1;
            }else {
                lo = mid + 1;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        Q34 test = new Q34();
        System.out.println(Arrays.toString(test.searchRange(arr, 6)));
    }
}
