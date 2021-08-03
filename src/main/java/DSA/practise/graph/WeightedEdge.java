package DSA.practise.graph;

public class WeightedEdge extends Edge implements Comparable<WeightedEdge> {
    private double weight;
    public WeightedEdge(int u, int v, double w) {
        super(u, v);
        this.weight = w;
    }

    public int other(int u){
        return u == this.u ? this.v : this.u;
    }

    public double weight(){
        return weight;
    }
    @Override
    public int compareTo(WeightedEdge o) {
        return Double.compare(this.weight, o.weight);
    }

    @Override
    public String toString() {
        return "WeightedEdge{" +
                "u=" + this.u +
                ", v=" + this.v +
                ", weight=" + weight +
                '}';
    }
}
