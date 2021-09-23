package DSA.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q322 {

    Map<Integer, Integer> map = new HashMap<>();
    private int[] coins;
    private int amount;

    public int coinChange(int[] coins, int amount) {

        this.coins = coins;
        this.amount = amount;
        return f(amount);
    }

    private int f(int x){
        if (x < 0){
            return -1;
        }else if (x == 0){
            return 0;
        }else {
            if (!map.containsKey(x)){
                int res = -1;
                for (int coin : coins) {
                    if (coin <= x){
                        int subProblem = f(x - coin);
                        if (subProblem != -1){
                            res = Math.min(res, 1 + subProblem);
                        }

                    }
                }
                map.put(x, res);
            }
            return map.get(x);
        }
    }

    public static void main(String[] args) {
        Q322 test = new Q322();
        int[] coins = {3};

        System.out.println(test.coinChange(coins, 2));
    }

}
