package DSA.leetcode;

public class Q81 {

    public boolean search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target) >= 0;
    }

    private int search(int[] nums, int lo, int hi, int target){

        while (lo <= hi){
            int mid = lo + (hi - lo)/2;
            if (target == nums[mid]){
                return mid;
            }else {

                if (nums[mid] >= nums[lo]){

                    if (nums[lo] <= target && target <= nums[mid]){
                        hi = mid - 1;
                    }else {
                        lo = mid + 1;
                    }

                }else {
                    if (nums[mid] <= target && target <= nums[hi]){
                        lo = mid + 1;
                    }else {
                        hi = mid - 1;
                    }
                }
            }
        }
        return -1;
    }
}
