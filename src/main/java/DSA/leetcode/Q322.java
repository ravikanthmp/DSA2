package DSA.leetcode;

import java.util.Arrays;

public class Q322 {

    public int coinChange(int[] coins, int amount) {

        int[] tab = new int[amount + 1];
        Arrays.fill(tab, Integer.MAX_VALUE);

        // base
        int maxCoin = Integer.MIN_VALUE;
        for (int coin : coins) {
            if (coin <= amount){
                tab[coin] = 1;
                maxCoin  = Math.max(maxCoin, coin);
            }

        }

        for (int i = maxCoin; i <= amount; i++) {

            for (int coin : coins) {
                if (coin <= i){
                    if (tab[i - coin] != Integer.MAX_VALUE){
                        tab[i] = Math.min(tab[i], 1 + tab[i - coin]);
                    }
                }
            }
        }

        return tab[amount] != Integer.MAX_VALUE ? tab[amount] : -1;
    }


    public static void main(String[] args) {
        Q322 test = new Q322();
        int[] coins = {1,2,5};

        System.out.println(test.coinChange(coins, 11));
    }

}
