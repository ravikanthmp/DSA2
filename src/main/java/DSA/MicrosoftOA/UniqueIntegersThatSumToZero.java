package DSA.MicrosoftOA;

import java.util.Arrays;

public class UniqueIntegersThatSumToZero {

    public int[] sumZero(int n) {
        int[] ans;
        if (n == 1){
            ans = new int[1];
            ans[0] = 0;
        }else {
            ans = new int[n];
            ans[0] = ((n % 2) != 0) ? 0 : n;
            int i = 1;

            int nDup = n;

            for (; i < ans.length; i++) {
                if (ans[i - 1] > 0){
                    ans[i] = -1 * ans[i - 1];
                }else {
                    ans[i] = --nDup;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        UniqueIntegersThatSumToZero test = new UniqueIntegersThatSumToZero();
        System.out.println(Arrays.toString(test.sumZero(5)));
    }

}
