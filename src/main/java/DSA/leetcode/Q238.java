package DSA.leetcode;

import java.util.Arrays;

public class Q238 {


    public int[] productExceptSelf(int[] nums) {

        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
        }

        int prefix = 1;
        int suffix = product;
        int[] productExceptSelf = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            suffix = suffix / nums[i];
            productExceptSelf[i] = prefix * suffix;
            prefix = prefix * nums[i];
        }
        return productExceptSelf;
    }


    public static void main(String[] args) {
        Q238 test = new Q238();
        int[] arr = {1,2,3 ,4};
        System.out.println(Arrays.toString(test.productExceptSelf(arr)));
    }
}
