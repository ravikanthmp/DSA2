package DSA.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q216 {

    List<List<Integer>> res = new ArrayList<>();
    private int k;
    private int n;

    public List<List<Integer>> combinationSum3(int k, int n) {

        this.k = k;
        this.n = n;
        solve(n, 0, new ArrayList<>());
        return res;
    }

    private void solve(int remaining, int idx, ArrayList<Integer> soFar) {
        if (remaining < 0 || idx > 9 || soFar.size() > k){
            return;
        }else if (remaining == 0){
            if (soFar.size() == k){
                res.add(new ArrayList<>(soFar));
            }
        }else {

            for (int i = idx + 1; i < 10; i++) {
                soFar.add(i);
                solve(remaining - i, i, soFar);
                soFar.remove(soFar.size() - 1);

            }
        }
    }

    public static void main(String[] args) {
        Q216 test = new Q216();
        System.out.println(test.combinationSum3(3, 9));
    }
}
