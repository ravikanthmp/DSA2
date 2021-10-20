package DSA.leetcode.topInterview.easy;

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }else if (nums.length == 1){
            return nums[0];
        }
        int[] tab = new int[nums.length];
        tab[nums.length - 1] = nums[nums.length - 1];
        tab[nums.length - 2] = Math.max(nums[nums.length - 2], nums[nums.length - 1]);
        for (int i = tab.length - 3; i >= 0; i--) {
            tab[i] = Math.max(nums[i] + tab[i + 2], tab[i + 1]);
        }
        return tab[0];
    }


}
