package DSA.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        f(nums, 0, new ArrayList<>(), results);

        return results;
    }

    private void f(int[] nums, int idx, List<Integer> soFar, List<List<Integer>> results){
        results.add(new ArrayList<>(soFar));

        for (int i = idx; i < nums.length; i++) {
            soFar.add(nums[idx]);
            f(nums, idx + 1, soFar, results);
            soFar.remove(soFar.size() - 1);
        }
    }


    public static void main(String[] args) {
        Q78 test = new Q78();
        int[] arr = {1, 2, 3};
        List<List<Integer>> subsets = test.subsets(arr);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
