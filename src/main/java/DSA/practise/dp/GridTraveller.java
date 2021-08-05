package DSA.practise.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GridTraveller {

    static class Pair {
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x;
        int y;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public static Pair of(int x, int y) {
            return new Pair(x, y);
        }
    }

    Map<Pair, Long> dp = new HashMap<>();

    int M;
    int N;

    Long res;

    public GridTraveller(int m, int n) {
        M = m;
        N = n;
        res = num(Pair.of(0, 0));
    }

    /*
        fib(0) = 0
        fib(1) = 1
         */
    private Long num(Pair pair) {

        if (dp.containsKey(pair)){
            return dp.get(pair);
        }

        int x = pair.x;
        int y = pair.y;
        if (x < 0 || y < 0) {
            return Long.valueOf(0);
        }

        if ((x == (M - 1)) && (y == (N - 1))) {
            return Long.valueOf(1);
        }

        Long res = 0L;

        boolean canGoDown = x < M - 1;
        if (canGoDown) {
            Long downRes = 0L;
            Pair down = Pair.of(x + 1, y);
            if (dp.containsKey(down)) {
                downRes = dp.get(down);
            } else {
                downRes = num(down);
            }
            res += downRes;
        }
        boolean canGoRight = y < N - 1;
        if (canGoRight){
            Pair right = Pair.of(x, y + 1);
            long rightRes = 0L;
            if (dp.containsKey(right)){
                rightRes = dp.get(rightRes);
            }else {
                rightRes = num(right);
            }
            res += rightRes;
        }

        dp.put(pair, res);
        return dp.get(pair);


    }

    public Long numberOfWays(){
        return res;
    }

    public static void main(String[] args) {
        GridTraveller gridTraveller = new GridTraveller(2, 3);

        System.out.println(gridTraveller.numberOfWays());

    }
}
