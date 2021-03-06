package DSA.practise.graph;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Graph {

    LinkedList<Integer>[] graph;

    public Graph(int V) {
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
        graph[v].addFirst(u);
    }

    public int E() {
        return Arrays.stream(graph).mapToInt(List::size).sum() / 2;
    }

    public int V(){
        return graph.length;
    }

    public Iterable<Integer> adj(int v){
        if (!validVertex(v)){
            throw new IllegalArgumentException(String.format("%d is illegal vertex", v));
        }
        return graph[v];
    }

}
