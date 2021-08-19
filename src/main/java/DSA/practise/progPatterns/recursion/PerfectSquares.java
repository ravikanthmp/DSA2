package DSA.practise.progPatterns.recursion;

import java.util.*;
import java.util.stream.Collectors;

public class PerfectSquares {

    private Set<Integer> visited = new HashSet<>();

    public int numSquares(int n) {

        List<Integer> M = new ArrayList<>();
        int i = 1;
        while (i*i <= n){
            M.add(i*i);
            i++;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited.add(0);
        int step = 0;
        while (!queue.isEmpty() ){
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int removed = queue.remove();
                if (removed == n){
                    return step;
                }
                for (Integer neighbour : neighbours(removed, M)) {
                    if (!visited.contains(neighbour)){
                        visited.add(neighbour);
                        queue.add(neighbour);
                    }
                }

            }
            step++;
        }
        return -1;
    }

    private List<Integer> neighbours(int x, List<Integer> M){
        return M.stream().map(m -> m + x).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        PerfectSquares perfectSquares = new PerfectSquares();
        System.out.println(perfectSquares.numSquares(26));
    }
}
