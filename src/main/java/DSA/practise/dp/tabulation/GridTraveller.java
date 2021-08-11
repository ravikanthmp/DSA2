package DSA.practise.dp.tabulation;

public class GridTraveller {

    private long[][] tab;
    private int N;
    private int M;

    public GridTraveller(int M, int N) {
        tab = new long[M + 1][N + 1];
        this.M = M;
        this.N = N;
        doIt();
    }

    private void doIt() {
       tab[1][1] = 1l;
        for (int i = 1; i <= M; i++) {
            for (int j = (i == 1 ? 2 : 1); j <= N; j++) {
                tab[i][j] = tab[i-1][j] + tab[i][j - 1];
            }
        }
    }

    public long numberOfWays(){
        return tab[M][N];
    }

    public static void main(String[] args) {

    }
}
