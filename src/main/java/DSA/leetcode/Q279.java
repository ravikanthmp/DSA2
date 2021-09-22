package DSA.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q279 {

    Map<Integer, Integer> memo ;

    public int numSquares(int n){
        this.memo = new HashMap<>();

        double sqrt = Math.sqrt(n);

        List<Integer> S = new LinkedList<>();
        for (int i = 1; i <= Math.ceil(sqrt); i++) {
            int square = i * i;
            if (square <= n){
                S.add(i * i);
            }
        }

        return f(n, S, memo);

    }

    private int f(int n, List<Integer> S, Map<Integer, Integer> memo){
        if (n == 0){
            return 0;
        }else if (n == 1){
            return 1;
        }else {
//            memo.computeIfAbsent(n, x -> {
//                int ans = Integer.MAX_VALUE;
//                for (Integer s : S) {
//                    if (x >= s){
//                        ans = Math.min(ans, 1 + f(x - s, S, memo));
//                    }
//                }
//                return ans;
//            });
            if (!memo.containsKey(n)){
                int ans = Integer.MAX_VALUE;
                for (Integer s : S) {
                    if (n >= s){
                        ans = Math.min(ans, 1 + f(n - s, S, memo));
                    }
                }
                memo.put(n, ans);
            }
            return memo.get(n);
        }
    }

    public static void main(String[] args) {
        Q279 test = new Q279();
        System.out.println(test.numSquares(13));
    }

}
