package DSA.leetcode.topInterview.easy;

public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n < 3){
            return n;
        }
        int prev = 2;
        int prevPrev = 1;
        for (int i = 3; i <= n; i++) {
            int temp = prevPrev;
            prevPrev = prev;
            prev = temp + prev;
        }

        return prev;

    }

}
