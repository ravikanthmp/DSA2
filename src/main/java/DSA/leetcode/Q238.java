package DSA.leetcode;

import java.util.Arrays;

public class Q238 {


    public int[] productExceptSelf(int[] nums) {

        int[] suffixProduct = suffixProduct(nums);
        int[] prefixProduct = prefixProduct(nums);

        int[] productExceptSelf = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            productExceptSelf[i] = prefixProduct[i] * suffixProduct[i];
        }
        return productExceptSelf;
    }

    private int[] prefixProduct(int[] nums) {
        int[] prefixProduct = new int[nums.length];
        prefixProduct[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
        }
        return prefixProduct;
    }

    private int[] suffixProduct(int[] nums) {
        int[] suffixProduct = new int[nums.length];
        suffixProduct[nums.length - 1] = 1;
        for (int i = suffixProduct.length - 2; i >= 0; i--) {
            suffixProduct[i] = suffixProduct[i + 1] * nums[i + 1];
        }
        return suffixProduct;
    }


    public static void main(String[] args) {
        Q238 test = new Q238();
        int[] arr = {1,2,3 ,4};
        System.out.println(Arrays.toString(test.productExceptSelf(arr)));
    }
}
