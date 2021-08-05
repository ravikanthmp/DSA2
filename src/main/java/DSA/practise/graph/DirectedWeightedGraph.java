package DSA.practise.graph;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DirectedWeightedGraph {

    LinkedList<DirectedWeightedEdge>[] graph;

    public DirectedWeightedGraph(int V) {
        this.graph = new LinkedList[V];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<DirectedWeightedEdge>();
        }
    }

    protected boolean validVertex(int i){
            return i >= 0 && i < graph.length;
    }

    public void addEdge(int u, int v, double w){

        if (!validVertex(u) || !validVertex(v)){
            throw new IllegalArgumentException("Cannot add edge. Check vertex!");
        }

        DirectedWeightedEdge edge = new DirectedWeightedEdge(u, v, w);
        graph[u].addFirst(edge);
    }


    public DirectedWeightedGraph reverse(){
        DirectedWeightedGraph diGraph = new DirectedWeightedGraph(this.V());
        for (int i = 0; i < this.V(); i++) {
            for (DirectedWeightedEdge edge : this.adj(i)){
                diGraph.addEdge(edge.to(), edge.from(), edge.weight());
            }
        }
        return diGraph;
    }

    public int E() {
        return Arrays.stream(graph).mapToInt(List::size).sum() / 2;
    }

    public int V(){
        return graph.length;
    }

    @Override
    public String toString() {
        return "DiGraph{" +
                "graph=" + Arrays.toString(graph) +
                '}';
    }

    public Iterable<DirectedWeightedEdge> adj(int v){
        if (!validVertex(v)){
            throw new IllegalArgumentException(String.format("%d is illegal vertex", v));
        }
        return graph[v];
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        String url = "https://algs4.cs.princeton.edu/44sp/tinyEWD.txt";
        // Different digraph Textbook one...
        DirectedWeightedGraph diGraph = GraphGenerator.directedWeightedGraph(url);
        System.out.println(diGraph);
    }

}
