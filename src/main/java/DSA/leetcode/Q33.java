package DSA.leetcode;

public class Q33 {
    public int search(int[] nums, int target) {
        int pivotIdx = findPivot(nums, 0, nums.length - 1);
        int idx = binarySearch(nums, 0, pivotIdx - 1, target);
        if(idx == -1){
            idx = binarySearch(nums, pivotIdx, nums.length - 1, target);
        }
        return idx;
    }

    private int findPivot(int[] nums, int lo, int hi){
        if(lo == hi) {
            return lo;
        }

        if(lo == hi - 1){
            return nums[lo] <= nums[hi] ? lo : hi;
        }

        int mid = lo + (hi - lo)/2;
        if(nums[lo] < nums[mid]){
            return findPivot(nums, mid, hi);
        }else{
            return findPivot(nums, lo, mid);
        }
    }

    private int binarySearch(int[] nums, int lo, int hi, int el){

        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid] == el){
                return mid;
            }
            if(nums[mid] < el){
                lo = mid + 1;
            }else{
                hi = mid - 1;
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
