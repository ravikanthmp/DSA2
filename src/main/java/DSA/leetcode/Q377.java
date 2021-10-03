package DSA.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q377 {


    private int[] nums;
    private int target;
    private List<List<Integer>> results;

    public int combinationSum4(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        Arrays.sort(nums);
        results = new ArrayList<>();
        test(0, target, new ArrayList<>());
        System.out.println(results);
        return results.size();
    }

    private void test(int idx, int remaining, List<Integer> soFar) {
        if (remaining < 0){
            return;
        }else if (remaining == 0){
            results.add(new ArrayList<>(soFar));
        }else {

            for (int i = 0; i < nums.length; i++) {
                soFar.add(nums[i]);
                test(i, remaining - nums[i], soFar);
                soFar.remove(soFar.size() - 1);
            }

        }
    }

    public static void main(String[] args) {
        Q377 test = new Q377();
        int[] arr = {1,2,3};
        int num = 4;
        System.out.println( test.combinationSum4(arr, num));;

    }
}
