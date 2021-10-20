package DSA.leetcode.topInterview.easy;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length + 1];
        int carry = 1;
        int j = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int colSum = carry + digits[i];
            carry = colSum / 10;
            res[j++] = colSum % 10;
        }
        if (carry != 0){
            res[j++] = carry;
        }
        reverse(res, 0, j - 1);
        return Arrays.copyOf(res, j);

    }

    private void reverse(int[] arr, int lo, int hi){
        while (lo < hi){
            int temp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = temp;
            lo++;
            hi--;
        }
    }

    public static void main(String[] args) {
        int[] digits = {4,3,2,1};
        PlusOne plusOne = new PlusOne();
        System.out.println(Arrays.toString(plusOne.plusOne(digits)));
    }

    private String convertToString(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for (int i = digits.length - 1; i >= 0; i--) {

        }
        return sb.toString();
    }
}
