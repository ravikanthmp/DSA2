package DSA.practise.graph.sp;

import DSA.practise.graph.DirectedWeightedEdge;
import DSA.practise.graph.DirectedWeightedGraph;
import DSA.practise.graph.GraphGenerator;
import DSA.practise.queue.IndexedMinPriorityQueueOfficial;
import DSA.practise.queue.IndexedPriorityQueue;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class DijkstraSP {
    private DirectedWeightedGraph graph;
    private int src;
    private List<DirectedWeightedEdge> edges;
    private double[] distTo;
    private DirectedWeightedEdge[] edgeTo;

    public DijkstraSP(DirectedWeightedGraph graph, int src) {
        this.graph = graph;
        this.src = src;
        edges = new ArrayList<>();
        distTo = new double[graph.V()];
        edgeTo = new DirectedWeightedEdge[graph.V()];
        dijkstraSP();
    }

    public Iterable<DirectedWeightedEdge> pathTo(int u){
        Deque<DirectedWeightedEdge> list = new ArrayDeque<>();
        for (DirectedWeightedEdge edge = edgeTo[u]; edge != null; edge = edgeTo[edge.from()]){
            list.add(edge);
        }
        return list;
    }

    private void relax(DirectedWeightedEdge edge, IndexedMinPriorityQueueOfficial<Double> minPQ){

        int u = edge.from();
        int v = edge.to();
        double w = edge.weight();
        if (distTo[v] > distTo[u] + edge.weight()){
            distTo[v] = distTo[u] + edge.weight();
            edgeTo[v] = edge;
            minPQ.changeKey(v, distTo[u] + edge.weight());
        }
    }

    private void dijkstraSP(){
        for (int i = 0; i < graph.V(); i++) {
            distTo[i] = Double.MAX_VALUE;
        }
        distTo[src] = 0;
        edgeTo[src] = null;

        IndexedMinPriorityQueueOfficial<Double> minPQ = new IndexedMinPriorityQueueOfficial<>(graph.V());
        for (int i = 0; i < graph.V(); i++){
            minPQ.insert(i, distTo[i]);
        }

        while (!minPQ.isEmpty()){

            Integer nearest = minPQ.delMin();
            for (DirectedWeightedEdge edge : graph.adj(nearest)) {
                relax(edge, minPQ);
            }

        }
    }

    private String pathToString(int u){
        double w = 0.0;
        StringBuilder sb = new StringBuilder();
        for (DirectedWeightedEdge edge : pathTo(u)) {
            sb.append(edge).append(" ");
            w += edge.weight();
        }
        sb.append("Weight= ").append(w);
        return sb.toString();
    }

    public double pathWeight(int u){
        double w = 0.0;

        for (DirectedWeightedEdge edge : pathTo(u)) {

            w += edge.weight();
        }
      return  w;
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        String url = "https://algs4.cs.princeton.edu/44sp/tinyEWD.txt";
        DirectedWeightedGraph directedWeightedGraph = GraphGenerator.directedWeightedGraph(url);
        DijkstraSP sp = new DijkstraSP(directedWeightedGraph, 0);
        for (int i = 0; i < directedWeightedGraph.V(); i++) {

            System.out.println(sp.pathToString(i));

        }
    }
}
