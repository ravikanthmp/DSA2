package DSA.leetcode;

import java.util.*;

public class Q279 {

    public int numSquares(int n){

        double sqrt = Math.sqrt(n);

        List<Integer> S = new LinkedList<>();
        for (int i = 1; i <= Math.ceil(sqrt); i++) {
            int square = i * i;
            if (square <= n){
                S.add(i * i);
            }
        }

        Queue<Integer> queue = new LinkedList<>(S);
        TreeSet<Integer> visited = new TreeSet<>(S);

        int step = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int first = queue.remove();
                if (first == n){
                    return step;
                }
                for(int s : S){
                    int x = first + s;
                    if (x <= n && !visited.contains(x)){
                        visited.add(x);
                        queue.add(x);
                    }
                }
            }
            step++;
        }
        return Integer.MAX_VALUE;
    }


    public static void main(String[] args) {
        Q279 test = new Q279();
        System.out.println(test.numSquares(13));
    }

}
