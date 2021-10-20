package DSA.leetcode.topInterview.easy;

public class ReverseBits {

    public int reverseBits(int n) {

        int y = 0;
        for (int i = 32; i > 0; i--) {
            int x = n & (1 << i);
            x = (x != 0) ? 1 : 0;
            y = y | (x << (32 - i));
        }

        return y;
    }


    public static void main(String[] args) {

    }
}
