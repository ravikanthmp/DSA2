package DSA.practise.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class WeightedGraph {
    private Comparator<WeightedEdge> cmp;
    LinkedList<WeightedEdge>[] graph;

    public WeightedGraph(int V, Comparator<WeightedEdge> cmp) {
        this.graph = new LinkedList[V];
        this.cmp = cmp;
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<WeightedEdge>();
        }
    }

    public WeightedGraph(int V) {
        this.graph = new LinkedList[V];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<WeightedEdge>();
        }
    }

    protected boolean validVertex(int i){
        return i >= 0 && i < graph.length;
    }

    public void addEdge(int u, int v, double w){

        if (!validVertex(u) || !validVertex(v)){
            throw new IllegalArgumentException("Cannot add edge. Check vertex!");
        }

        WeightedEdge edge = new WeightedEdge(u, v, w);
        graph[u].addFirst(edge);
        graph[v].addFirst(edge);
    }

    public int E() {
        return Arrays.stream(graph).mapToInt(List::size).sum() / 2;
    }

    public int V(){
        return graph.length;
    }


    public Iterable<WeightedEdge> adj(int v){
        if (!validVertex(v)){
            throw new IllegalArgumentException(String.format("%d is illegal vertex", v));
        }
        return graph[v];
    }
}
