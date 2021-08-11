package DSA.practise.dp.tabulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void fib() {
        Fibonacci fib = new Fibonacci(41);
        Assertions.assertEquals(fib.fib(41), 165580141L);
    }
}