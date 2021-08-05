package DSA.practise.graph;

public class DirectedWeightedEdge implements Comparable<DirectedWeightedEdge> {
    private int u, v;
    private double w;

    public DirectedWeightedEdge(int u, int v, double w){
        this.u = u;
        this.v = v;
        this.w = w;
    }

    public int from(){
        return u;
    }

    public int to(){
        return v;
    }

    public double weight(){
        return w;
    }

    @Override
    public int compareTo(DirectedWeightedEdge o) {
        return Double.compare(this.w, o.weight());
    }

    @Override
    public String toString() {
        return "{" +
                "u=" + u +
                ", v=" + v +
                ", w=" + w +
                '}';
    }
}
