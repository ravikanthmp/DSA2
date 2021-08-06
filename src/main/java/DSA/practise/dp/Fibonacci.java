package DSA.practise.dp;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    Map<Integer, Long> dp = new HashMap<>();

    /*
    fib(0) = 0
    fib(1) = 1
     */
    public Long fib(int i){
        if (i < 2){
            return Long.valueOf(i);
        }else if (dp.containsKey(i)){
            return dp.get(i);
        }else {
            Long res = fib(i - 1) + fib(i - 2);
            dp.put(i, res);
            return res;
        }
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();

        for (int i = 0; i < 10; i++) {
            int x = (int) (50 * Math.random());
            System.out.println("x = " + x + ", fib(x) = " + fibonacci.fib(x));
        }
    }
}
