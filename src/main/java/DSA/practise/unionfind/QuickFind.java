package DSA.practise.unionfind;

public class QuickFind implements UF{

    private int[] id;

    public QuickFind(int N) {
        this.id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    @Override
    public boolean connected(int i, int j) {
        return id[i] == id[j];
    }

    @Override
    public void union(int i, int j) {
        int idOfI = id[i];
        int idOfJ = id[j];
        for (int k = 0; k < id.length; k++) {
            if (id[k] == idOfJ){
                id[k] = idOfI;
            }
        }
    }

    @Override
    public int find(int i) {
        return id[i];
    }
}
