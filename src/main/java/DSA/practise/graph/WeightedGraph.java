package DSA.practise.graph;

import DSA.practise.linkedlists.SinglyLinkedList;

import java.util.Comparator;

public class WeightedGraph extends Graph {
    private Comparator<WeightedEdge> cmp;

    public WeightedGraph(int V, Comparator<WeightedEdge> cmp) {
        super(V);
        this.graph = new SinglyLinkedList[V];
        this.cmp = cmp;
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new SinglyLinkedList<WeightedEdge>();
        }
    }

    public WeightedGraph(int V) {
        super(V);
        this.graph = new SinglyLinkedList[V];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new SinglyLinkedList<WeightedEdge>();
        }
    }


    public void addEdge(int u, int v, double w){

        if (!validVertex(u) || !validVertex(v)){
            throw new IllegalArgumentException("Cannot add edge. Check vertex!");
        }

        Edge edge = new WeightedEdge(u, v, w);
        graph[u].addFirst(edge);
        graph[v].addFirst(edge);
    }


}
