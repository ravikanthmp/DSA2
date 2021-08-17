package DSA.leetcode;


public class Q43 {


    public int jump(int[] nums) {

        int currLevelEnd = nums[0];
        int nextLevelEnd = 0;
        int steps = 1;
        for (int i = 1; i < nums.length ; i++) {

            if (i == currLevelEnd){
                if (i != nums.length - 1){
                    steps++;
                }
                currLevelEnd = nextLevelEnd;
                nextLevelEnd = 0;
            }else {
                nextLevelEnd = Math.max(nextLevelEnd, i + nums[i]);
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1};
        Q43 test = new Q43();
        System.out.println(test.jump(arr));
    }
}
