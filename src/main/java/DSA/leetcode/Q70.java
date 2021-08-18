package DSA.leetcode;

public class Q70 {
    public int climbStairs(int n) {
        if (n <=2 ){
            return n;
        }else {
            int prev = 2;
            int prevPrev = 1;
            int curr = prev + prevPrev;
            for (int i = 3; i <= n; i++) {
                curr = prev + prevPrev;
                prevPrev = prev;
                prev = curr;
            }
            return curr;
        }
    }
}
