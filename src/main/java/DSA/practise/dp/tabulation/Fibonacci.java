package DSA.practise.dp.tabulation;

public class Fibonacci {

    private Long[] tab;
    private int N;

    public Fibonacci(int N) {
        tab = new Long[N + 1];
        this.N = N;
        tab[0] = 0L;
        tab[1] = 1L;
        fib();
    }

    private void fib() {
        for (int i = 2; i <= N; i++) {
            tab[i] = tab[i - 1] + tab[i - 2];
        }
    }

    public Long fib(int x){
        return tab[x];
    }

    public static void main(String[] args) {

    }
}
