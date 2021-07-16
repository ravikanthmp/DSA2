package DSA.practise.graph;

public class Edge {
    int u;
    int v;

    public Edge(int u, int v) {
        this.u = u;
        this.v = v;
    }

    public int other(int vertex){
        if (vertex == u){
            return v;
        }else {
            return u;
        }
    }
}
