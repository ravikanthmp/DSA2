package DSA.leetcode;

import java.util.Arrays;

public class Q238 {

    public int[] productExceptSelf(int[] nums) {

        int[] res = new int[nums.length];
        int[] left = left(nums);
        int[] right = right(nums);

        System.out.println(Arrays.toString(left));

        res[0] = right[0];
        res[nums.length - 1] = left[nums.length - 1];
        for (int i = 1; i < nums.length - 1; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }

    int[] right(int[] nums){
        int[] rightProduct = new int[nums.length];
        int x = 1;
        rightProduct[rightProduct.length - 1] = 1;
        for (int i = rightProduct.length - 2; i >= 0; i--) {
            rightProduct[i] = x * nums[i + 1];
            x = rightProduct[i];
        }
        return rightProduct;
    }

    int[] left(int[] nums){
        int[] leftProduct = new int[nums.length];
        int x = 1;
        leftProduct[0] = x;
        for (int i = 1; i < leftProduct.length; i++) {
            leftProduct[i] = x * nums[i - 1];
            x = leftProduct[i];
        }
        return leftProduct;
    }

    public static void main(String[] args) {
        Q238 test = new Q238();
        int[] arr = {1,2,3 ,4};
        System.out.println(Arrays.toString(test.productExceptSelf(arr)));
    }
}
