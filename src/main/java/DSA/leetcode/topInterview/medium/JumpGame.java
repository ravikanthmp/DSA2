package DSA.leetcode.topInterview.medium;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int needToReach = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != 0){
                if (nums[i] + i >= needToReach){
                    needToReach = i;
                }
            }
        }
        return needToReach == 0;
    }

}
