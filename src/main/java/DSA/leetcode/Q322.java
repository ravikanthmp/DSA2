package DSA.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q322 {


    public int coinChange(int[] coins, int amount) {

        int[] tab = new int[amount + 1];
        tab[0] = 0;
        for (int i = 1; i < tab.length; i++) {
            int init = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin <= i && tab[i - coin] != Integer.MAX_VALUE){
                    init = Math.min(init, 1 + tab[i - coin]);
                }
            }
            tab[i] = init;
        }
        return tab[amount] != Integer.MAX_VALUE ? tab[amount] : -1;

    }


    public static void main(String[] args) {
        Q322 test = new Q322();
        int[] coins = {3};

        System.out.println(test.coinChange(coins, 2));
    }

}
