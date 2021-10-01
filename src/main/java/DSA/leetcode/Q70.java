package DSA.leetcode;

public class Q70 {
    public int climbStairs(int n) {
        if (n < 3){
            return n;
        }else {
            int pp = 1;
            int p = 2;
            for (int i = 3; i <= n; i++) {
                int temp = p;
                p += pp;
                pp = temp;
            }
            return p;
        }
    }

    public static void main(String[] args) {
        int n = 30;
        Q70 test = new Q70();
        System.out.println(test.climbStairs(n));
    }
}
