package DSA.leetcode.topInterview.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange {

    private int[] coins;
    private int amount;
    Map<Integer, Integer> memo;

    public int coinChange(int[] coins, int amount) {

        if(amount == 0){
            return 0;
        }
        Arrays.sort(coins);
        if (amount < coins[0]){
            return -1;
        }
        this.coins = coins;
        this.amount = amount;
        this.memo = new HashMap<>();

        return solve(amount);
    }


    private int solve(int amount){

        if (amount == 0){
            return 0;
        }else {
            if (!memo.containsKey(amount)){
                int ans = Integer.MAX_VALUE;
                for (int coin : coins) {
                    if (coin <= amount){
                        int subProblem = solve(amount - coin);
                        if (subProblem != -1){
                            ans = Math.min(ans, 1 + subProblem);
                        }

                    }
                }

                if (ans != Integer.MAX_VALUE){
                    memo.put(amount, ans);
                }else {
                    memo.put(amount, -1);
                }
            }
            return memo.get(amount);
        }
    }
}
