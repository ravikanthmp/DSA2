package DSA.leetcode.contest.weekly261;

import java.util.Arrays;

public class Q5891 {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int MSum = Arrays.stream(rolls).sum();
        int grandTotal = (mean) * (n + rolls.length);
        int NSum = grandTotal - MSum;
        return nums(NSum, n);
    }

    private int[] nums(int sum, int k){
        if (sum > 6 * k || sum < k){
            return new int[0];
        }else {
            int avg = sum/k;
            int remaining = sum;

            int nextOneCount = remaining - (avg * k);


            int[] arr = new int[k];
            int i = 0;
            int j = 0;

            for (j = 0; j < nextOneCount; j++) {
                arr[j] = avg + 1;
                remaining -= arr[j];
            }
            while (j < arr.length - 1){
                arr[j] = avg;
                remaining -= arr[j];
                j++;
            }
            arr[arr.length - 1] = remaining;
            return arr;
        }
    }


    public static void main(String[] args) {

        int[] rolls = {4,5,6,2,3,6,5,4,6,4,5,1,6,3,1,4,5,5,3,2,3,5,3,2,1,5,4,3,5,1,5};
        int mean = 4, n = 40;
        Q5891 test = new Q5891();
        System.out.println(Arrays.toString(test.missingRolls(rolls, mean, n)));
    }
}
