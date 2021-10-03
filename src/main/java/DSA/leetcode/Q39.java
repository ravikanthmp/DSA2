package DSA.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q39 {

    private int[] candidates;
    private int target;
    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        Arrays.sort(candidates);
        this.target = target;
        combinationSum(0, target, new ArrayList<>());
        return resultList;
    }

    private void combinationSum(int idx, int remaining, List<Integer> soFar){
        if (remaining < 0){
            return;
        } else if (remaining == 0){
            resultList.add(new ArrayList<>(soFar));
        }else {

            for (int i = idx; i < candidates.length; i++) {
                soFar.add(candidates[i]);
                combinationSum(i, remaining - candidates[i], soFar);
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
