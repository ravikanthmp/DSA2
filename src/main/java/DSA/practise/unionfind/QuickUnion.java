package DSA.practise.unionfind;

public class QuickUnion implements UF{
    private int[] id;

    public QuickUnion(int N){
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /**
     * Could be O(N) for skinny tree
     * @param i
     * @param j
     */
    @Override
    public boolean connected(int i, int j) {
        return find(i) == find(j);
    }

    /**
     * Could be O(N) for skinny tree
     * @param i
     * @param j
     */
    @Override
    public void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        id[rootI] = id[rootJ];
    }

    @Override
    public int find(int i) {
        while (i != id[i]){
            i = id[i];
        }
        return i;
    }
}
