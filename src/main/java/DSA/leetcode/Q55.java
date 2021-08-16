package DSA.leetcode;

public class Q55 {

    private boolean[] memo;

    public boolean canJump(int[] nums) {
        memo = new boolean[nums.length];
        memo[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            int farthest = Math.min(nums.length - 1, i + nums[i]);
            for (int j = i + 1; j <= farthest; j++) {
                if (memo[j]){
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[0];
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 0, 4};
        Q55 test = new Q55();
        System.out.println(test.canJump(arr));
    }

}
