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
        for (int i = 0; i < nums.length - 2 && inRange(nums, i) && nums[i] <= 0; i = next(nums, i)) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k && inRange(nums, j) && inRange(nums, k)){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0){
                   resultList.add(List.of(nums[i], nums[j], nums[k]));
                   j = next(nums, j);
                }else if (sum < 0){
                    j = next(nums, j);
                }else {
                    k = previous(nums, k);
                }
            }
        }
        return resultList;
    }

    private int next(int[] nums, int i) {

        int resultIdx = -1;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] > nums[i]){
                return j;
            }
        }
        return resultIdx;
    }

    private boolean inRange(int[] nums, int i){
        return i >= 0 && i < nums.length;
    }

    private int previous(int[] nums, int i){
        int resultIdx = -1;
        for (int j = i - 1; j >= 0 ; j--) {
            if (nums[j] < nums[i]){
                return j;
            }
        }

        return resultIdx;
    }

    public static void main(String[] args) {
        Q15 threeSum = new Q15();
        int[] arr = {0, 0, 0};
        System.out.println(threeSum.threeSum(arr));
    }

}
