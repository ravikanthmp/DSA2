package DSA.practise.unionfind;

public class WeightedUnionFind implements UF{
    private int[] id;
    private int[] size;

    public WeightedUnionFind(int N){
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
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
        if (size(rootI) >= size(rootJ)) {
            size[rootI] += size[rootJ];
            id[rootJ] = id[rootI];
        }else {
            size[rootJ] += size[rootI];
            id[rootI] = id[rootJ];
        }

    }

    @Override
    public int find(int i) {
        while (i != id[i]){
            i = id[i];
        }
        return i;
    }

    private int size(int i){
        return size[i];
    }
}
