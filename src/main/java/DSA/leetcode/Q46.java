package DSA.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q46 {

    private List<List<Integer>> results;

    public List<List<Integer>> permute(int[] nums) {

        this.results = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        permute(list, new ArrayList<>());
        return results;
    }

    private void permute(List<Integer> remaining, List<Integer> soFar){
        if (remaining.isEmpty()){
            results.add(new ArrayList<>(soFar));
        }else{
            int N = remaining.size();;
            for (int i = 0; i < N; i++) {
                Integer removed = remaining.remove(0);
                soFar.add(removed);
                permute(remaining, soFar);
                soFar.remove(soFar.size() - 1);
                remaining.add(removed);
            }
        }
    }

    public static void main(String[] args) {
        Q46 test = new Q46();
        int[] arr = {1, 2, 3};
        for (List<Integer> list : test.permute(arr)) {
            System.out.println(list);
        }

    }
}
