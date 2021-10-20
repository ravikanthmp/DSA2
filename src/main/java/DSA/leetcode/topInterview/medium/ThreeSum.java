package DSA.leetcode.topInterview.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length < 3){
            return res;
        }

        Arrays.sort(nums);

        if (nums[nums.length - 1] < 0){
            return res;
        }

        for (int i = 0; i < nums.length && nums[i] <= 0; ) {

            int j = i + 1;
            int k = nums.length - 1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0){
                    res.add(List.of(nums[i], nums[j], nums[k]));

                    j++;
                    while (j < nums.length && nums[j] == nums[j - 1]){
                        j++;
                    }

                    k--;
                    while (k > j && nums[k] == nums[k + 1]){
                        k--;
                    }

                }else if (sum < 0){
                    j++;
                    while (j < nums.length && nums[j] == nums[j - 1]){
                        j++;
                    }
                }else {
                    k--;
                    while (k > j && nums[k] == nums[k + 1]){
                        k--;
                    }
                }
            }

            i++;
            while (i < nums.length && nums[i] == nums[i - 1]){
                i++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();

    }
}
