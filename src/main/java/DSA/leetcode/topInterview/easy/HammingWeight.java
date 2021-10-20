package DSA.leetcode.topInterview.easy;

public class HammingWeight {

    public int hammingWeight(int n) {

        int count = 0;

        int x = 1;
        for (int i = 0; i < 32; i++) {
            x = x << i;
            if ( (n & x) != 0){
                count++;
            }
        }
        return count;
    }
}
