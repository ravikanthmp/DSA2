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
        search(target, new ArrayList<>());
        return results;
    }

    private void search(int remaining, List<Integer> soFar){
        if(remaining < 0){
            return;
        }
        if (remaining == 0){
            results.add(new ArrayList(soFar));
        }else {
            Integer prev = null;
            Integer minCandidate = soFar.isEmpty() ? null : soFar.get(soFar.size() - 1);

            for (int candidate : candidates) {
                if(prev != null && prev.equals(candidate)){
                    continue;
                }else{
                    prev = candidate;
                }
                if (minCandidate != null && candidate < minCandidate){
                    continue;
                }
                soFar.add(candidate);
                search(remaining - candidate, soFar);
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
