package DSA.leetcode.topInterview.easy;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }else {

            int j = 0;
            for (int curr = 1; curr < nums.length; curr++) {
                if (nums[curr] != nums[curr - 1]){
                    nums[++j] = nums[curr];
                }
            }

            return j + 1;
        }
    }

}
