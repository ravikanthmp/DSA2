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
        if (nums.length == 0){
            return Collections.emptyList();
        }

        Arrays.sort(nums);

        List<List<Integer>> resultList = new ArrayList<>();
        if(nums.length < 3){
            return resultList;
        }

        for (int i = 0; i < nums.length && nums[i] <= 0 ; ) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k){
                if (nums[j] + nums[k] == Math.abs(nums[i])){
                    resultList.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while ( j <k && nums[j] == nums[j -1]){
                        j++;
                    }
                    while (k > j && nums[k] == nums[k + 1]){
                        k--;
                    }
                }else if (nums[j] + nums[k] < Math.abs(nums[i])){
                    j++;
                }else {
                    k--;
                }
            }

            i++;
            while (i < nums.length && nums[i] == nums[i - 1]){
                i++;
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        Q15 threeSum = new Q15();
        int[] arr = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        System.out.println(threeSum.threeSum(arr));
    }

}
