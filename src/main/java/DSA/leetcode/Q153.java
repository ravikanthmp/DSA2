package DSA.leetcode;

public class Q153 {

    public int findMin(int[] nums) {
        int idx = findPivot(nums, 0, nums.length - 1);
        if (idx != -1){
            return nums[idx];
        }else {
            throw new RuntimeException("Lol");
        }
    }

    private int findPivot(int[] nums, int lo, int hi) {

        int ans = -1;
        while (lo <= hi){
            if (hi == lo){
                return lo;
            } else if (hi == lo  + 1){
                return nums[lo] <= nums[hi] ? lo : hi;
            }

            int mid = lo + (hi - lo)/2;
            if (nums[lo] > nums[hi]){
                lo = mid + 1;
            }else {
                hi = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr ={3,4,5,1,2};
        Q153 test = new Q153();
        System.out.println(test.findMin(arr));
    }

}
