package DSA.practise.unionfind;

public interface UF {
    public boolean connected(int i, int j);
    public void union(int i, int j);
    public int find(int i);
}
