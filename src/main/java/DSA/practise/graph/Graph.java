package DSA.practise.graph;

import DSA.practise.linkedlists.List;
import DSA.practise.linkedlists.SinglyLinkedList;

import java.util.Arrays;
import java.util.Iterator;

public class Graph {

    List[] graph;

    public Graph(int V) {
        this.graph = new SinglyLinkedList[V];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new SinglyLinkedList<>();
        }
    }

    protected boolean validVertex(int i){
            return i >= 0 && i < graph.length;
    }

    public void addEdge(int u, int v){

        if (!validVertex(u) || !validVertex(v)){
            throw new IllegalArgumentException("Cannot add edge. Check vertex!");
        }

       Edge edge = new Edge(u, v);
        graph[u].addFirst(edge);
        graph[v].addFirst(edge);
    }

    public int edges() {
        return Arrays.stream(graph).mapToInt(List::size).sum() / 2;
    }

    public int V(){
        return graph.length;
    }

    public Iterable adj(int v){
        if (!validVertex(v)){
            throw new IllegalArgumentException(String.format("%d is illegal vertex", v));
        }
        return graph[v];
    }

}
