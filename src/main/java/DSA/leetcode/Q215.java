package DSA.leetcode;

public class Q215 {

    public int findKthLargest(int[] nums, int k) {
        int[] afterSort = sort(nums);
        return afterSort[nums.length - k];
    }

    private int[] sort(int[] nums) {

        int shift = 10000;

        // init
        int[] count = new int[(2 * shift) + 1];

        // freq
        for (int i = 0; i < nums.length; i++) {
            count[nums[i] + shift]++;
        }

        // accumulate
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int idx = count[nums[i]];
            temp[idx] = nums[i];
            count[nums[i]] = idx + 1;
        }

        nums = temp;
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        int k = 2;
        Q215 test = new Q215();
        System.out.println(test.findKthLargest(arr, k));
    }
}
