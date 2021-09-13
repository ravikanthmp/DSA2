package DSA.leetcode;

public class Q55 {


    public boolean canJump(int[] nums) {

        int leftmostIndexThatCanReach = nums.length -1 ;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= leftmostIndexThatCanReach){
                leftmostIndexThatCanReach = i;
            }
        }
        return leftmostIndexThatCanReach == 0;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 0, 4};
        Q55 test = new Q55();
        System.out.println(test.canJump(arr));
    }

}
