package DSA.leetcode.topInterview.medium;

public class PeakElement {

    public int findPeakElement(int[] nums) {
        return findPeak(nums, 0, nums.length - 1);
    }

    int findPeak(int[] nums ,int lo, int hi){
        if (hi == lo){
            return hi;
        }else if (hi == lo + 1){
            return nums[hi] > nums[lo] ? hi : lo;
        }else {
            int mid = (hi + lo)/2;
            if ( (nums[mid - 1] < nums[mid]) && (nums[mid] > nums[mid + 1])){
                return mid;
            }else if (nums[mid] < nums[mid + 1]){
                return findPeak(nums, mid + 1, hi);
            }else {
                return findPeak(nums, lo, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,3,5,6,4};
        PeakElement peakElement = new PeakElement();
        System.out.println(peakElement.findPeakElement(arr));
    }
}
