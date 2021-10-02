package DSA.leetcode;

import java.util.Arrays;

public class Q377 {


    public int combinationSum4(int[] nums, int target) {
        int[] tab = new int[target + 1];
        Arrays.sort(nums);
        for (int num : nums){
            if(num <= target){
                tab[num] = 1;
            }

        }


        if (target < nums[0]){
            return 0;
        }else {
            for (int i = nums[0]; i <= target ; i++) {

                for (int num : nums) {
                    if (num + i <= target){
                        tab[num + i] += tab[i];
                    }
                }

            }
        }

        return tab[target];

    }

    public static void main(String[] args) {
        Q377 test = new Q377();
        int[] arr = {1,2,3};
        int num = 4;
        System.out.println( test.combinationSum4(arr, num));;

    }
}
