package DSA.leetcode;
public class Q33 {


    public int findMinIndex(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi){

            if (lo == hi){
                return lo;
            }else if (hi == lo + 1){
                return nums[lo] < nums[hi] ? lo : hi;
            }else {

                int mid = lo + (hi - lo)/2;
                if (nums[mid] < nums[mid - 1]){
                    return mid;
                }else if (nums[mid] > nums[mid + 1]){
                    return mid + 1;
                }

                if (nums[mid] > nums[hi]){
                    lo = mid + 1;
                }else {
                    hi = mid - 1;
                }

            }



        }
        return -1;
    }


    public int search(int[] nums, int target) {
        int minIndex = findMinIndex(nums);
        if (minIndex < 0){
            return -1;
        }else {
            int lo;
            int hi;
            if (target >= nums[minIndex] && target <= nums[nums.length - 1]){
                lo = minIndex;
                hi = nums.length - 1;
            }else {
                lo = 0;
                hi = minIndex - 1;
            }
            return binarySearch(nums, lo, hi, target);
        }
    }

    private int binarySearch(int[] nums, int lo, int hi, int target) {
        while (lo <= hi){
            int mid = lo + (hi - lo)/2;
            int cmp = Integer.compare(target, nums[mid]);
            if (cmp == 0){
                return mid;
            }else if (cmp < 0){
                hi = mid - 1;
            }else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        Q33 test = new Q33();
        System.out.println(test.search(arr, 0));

    }
}
