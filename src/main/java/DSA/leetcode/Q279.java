package DSA.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q279 {

    public int numSquares(int n){

        int[] tab = new int[n + 1];
        tab[0] = 0;
        tab[1] = 1;

        double sqrt = Math.sqrt(n);

        List<Integer> S = new LinkedList<>();
        for (int i = 1; i <= Math.ceil(sqrt); i++) {
            int square = i * i;
            if (square <= n){
                S.add(i * i);
            }
        }

        for (int i = 2; i <= n; i++) {
            int res = Integer.MAX_VALUE;
            for (int s : S){
                if (s > i){
                    break;
                }else {
                    res = Math.min(res, 1 + tab[i - s]);
                }
            }
            tab[i] = res;
        }

        return tab[n];

    }


    public static void main(String[] args) {
        Q279 test = new Q279();
        System.out.println(test.numSquares(13));
    }

}
