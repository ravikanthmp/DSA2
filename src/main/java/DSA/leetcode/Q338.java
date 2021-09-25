package DSA.leetcode;

import java.util.Arrays;

public class Q338 {
    public int[] countBits(int n) {

        int[] res = new int[n + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = count(i);
        }
        return res;
    }

    private int count(int x){
        int count = 0;
        while (x > 0){
            if ((x & 1) == 1){
                count++;
            }
            x = x>>1;
        }
        return count;
    }

    public static void main(String[] args) {
        Q338 test = new Q338();
        System.out.println(Arrays.toString(test.countBits(5)));
    }
}
