package DSA.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q15 {

    /**
     * Time : O(N ^ 2)
     * Space : O(1)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0){
                    res.add(List.of(nums[i], nums[j], nums[k]));

                    j++;
                    while (j < k && nums[j] == nums[j - 1]){
                        j++;
                    }


                }else if (sum < 0){
                    j++;
                    while (j < k && nums[j] == nums[j - 1]){
                        j++;
                    }

                }else {

                    k--;
                    while (k < nums.length - 1 && j < k && nums[k] == nums[k + 1]){
                        k--;
                    }
                }
            }

            i++;
            while (i > 0 && i < nums.length && nums[i] == nums[i - 1]){
                i++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Q15 threeSum = new Q15();
        int[] arr = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        System.out.println(threeSum.threeSum(arr));
    }

}
