package DSA.leetcode;

public class Q154 {

    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi){
            if (lo == hi){
                return nums[lo];
            }else if (hi == lo + 1){
                return Math.min(nums[lo], nums[hi]);
            }else {
                int mid = lo + (hi - lo)/2;
                if (nums[mid] >= nums[lo]){
                    lo = mid;
                }else {
                    hi = mid;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Q154 test = new Q154();
        int[] arr = {2,2,2,3,3,4,5,6,0,0,1};
        System.out.println(test.findMin(arr));
    }

}
