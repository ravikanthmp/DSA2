package DSA.leetcode;


import java.util.LinkedList;
import java.util.Queue;

public class Q322 {


    public int coinChange(int[] coins, int amount) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(amount);
        int step = 0;
        boolean[] visited = new boolean[amount + 1];
        visited[amount] = true;
        while (!queue.isEmpty()){

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int first = queue.remove();
                if (first == 0){
                    return step;
                }
                for (int coin : coins) {
                    int next = first - coin;
                    if (next >= 0){
                        if (!visited[next]){
                            visited[next] = true;
                            queue.add(next);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }


    public static void main(String[] args) {
        Q322 test = new Q322();
        int[] coins = {1,2,5};

        System.out.println(test.coinChange(coins, 11));
    }

}
