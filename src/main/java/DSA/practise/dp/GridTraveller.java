package DSA.practise.dp;

import java.lang.reflect.Parameter;
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

    private Long num(Pair pair) {

        if (dp.containsKey(pair)){
            return dp.get(pair);
        }

        int x = pair.x;
        int y = pair.y;

        if (!isValid(pair)){
            return 0L;
        }

        if ((x == (M - 1)) && (y == (N - 1))) {
            return Long.valueOf(1);
        }

        Long res = 0L;

        res += num(Pair.of(x + 1, y));
        res += num(Pair.of(x, y + 1));

        dp.put(pair, res);
        return dp.get(pair);


    }

    private boolean isValid(Pair pair){
        int x = pair.x;
        int y = pair.y;
        return (x >= 0 && x < M) && (y >=0 && y < N);
    }

    public Long numberOfWays(){
        return res;
    }

    public static void main(String[] args) {
        GridTraveller gridTraveller = new GridTraveller(2, 3);

        System.out.println(gridTraveller.numberOfWays());

    }
}
