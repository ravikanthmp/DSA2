package DSA.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q39 {

    private int[] candidates;
    private int target;
    private List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        Arrays.sort(candidates);
        search(0, target, new ArrayList<>());
        return results;
    }

    private void search(int idx, int sumRemaining, List<Integer> soFar){
        if (sumRemaining < 0){
            return;
        }else if (sumRemaining == 0){
            results.add(new ArrayList<>(soFar));
        }else {

            for (int i = idx; i < candidates.length; i++) {
                soFar.add(candidates[i]);
                int r = sumRemaining - candidates[i];
                search(i, r, soFar);
                soFar.remove(soFar.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        Q39 test = new Q39();
        System.out.println(test.combinationSum(arr, 7));
    }
}
