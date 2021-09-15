package DSA.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q78 {

    private List<List<Integer>> results = new ArrayList<>();
    private int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        subsets(0, new ArrayList<>());
        return results;
    }

    private void subsets(int idx, List<Integer> list){
        if (idx == nums.length){
            results.add(new ArrayList<>(list));
        }else {

            // include
            list.add(nums[idx]);
            subsets(idx + 1, list);
            list.remove(list.size() - 1);

            // exclude
            subsets(idx + 1, list);
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
