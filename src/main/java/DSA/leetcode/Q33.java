package DSA.leetcode;
public class Q33 {

    public int search(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi){
            int mid = lo + (hi - lo)/2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[lo] < nums[hi]){
                if (target > nums[mid]){
                    lo = mid + 1;
                }else {
                    hi = mid - 1;
                }
            }else if (nums[mid] > nums[hi]){
                if (target >= nums[lo] && target < nums[mid]){
                    hi = mid - 1;
                }else {
                    lo = mid + 1;
                }
            }else {
                if (target > nums[mid] && target < nums[hi]){
                    lo = mid + 1;
                }else {
                    hi = mid - 1;
                }
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
