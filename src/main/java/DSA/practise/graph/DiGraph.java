package DSA.practise.graph;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DiGraph {

    LinkedList<Integer>[] graph;

    public DiGraph(int V) {
        this.graph = new LinkedList[V];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
    }

    protected boolean validVertex(int i){
            return i >= 0 && i < graph.length;
    }

    public void addEdge(int u, int v){

        if (!validVertex(u) || !validVertex(v)){
            throw new IllegalArgumentException("Cannot add edge. Check vertex!");
        }

        graph[u].addFirst(v);
    }


    public DiGraph reverse(){
        DiGraph diGraph = new DiGraph(this.V());
        for (int i = 0; i < this.V(); i++) {
            for (int v : this.adj(i)){
                diGraph.addEdge(v, i);
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

    public Iterable<Integer> adj(int v){
        if (!validVertex(v)){
            throw new IllegalArgumentException(String.format("%d is illegal vertex", v));
        }
        return graph[v];
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        String url = "https://algs4.cs.princeton.edu/42digraph/tinyDG.txt";
        // Different digraph Textbook one...
        DiGraph diGraph = GraphGenerator.diGraph(url);
        System.out.println(diGraph);
    }

}
