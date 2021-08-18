package DSA.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q78 {

    private List<List<Integer>> results = new ArrayList<>();
    private int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        results.add(Collections.emptyList());
        subsets(0, new ArrayList<>());
        return results;
    }

    private void subsets(int idx, List<Integer> soFar){
        if (idx == nums.length){
            results.add(new ArrayList<>(soFar));
        }


        for (int i = idx; i < nums.length; i++) {

            if (i == 1){
                System.out.println("Cds");
            }
            soFar.add(nums[i]);
            subsets(i + 1, soFar);
            soFar.remove(soFar.size() - 1);
        }
    }

    public static void main(String[] args) {
        Q78 test = new Q78();
        int[] arr = {1, 2, 3, 4};
        List<List<Integer>> subsets = test.subsets(arr);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
