package DSA.practise.graph.sp;

import DSA.practise.graph.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.Deque;

public class AcyclicSP {
    private DirectedWeightedGraph graph;
    private int source;
    private double[] distTo;
    private DirectedWeightedEdge[] edgeTo;
    private boolean isCycle;

    public AcyclicSP(DirectedWeightedGraph graph, int source) {
        Cycle cycle = new Cycle(graph);
        isCycle = cycle.hasCycle();
        if (!isCycle){
            this.graph = graph;
            this.source = source;
            this.distTo = new double[graph.V()];
            this.edgeTo = new DirectedWeightedEdge[graph.V()];
            for (int i = 0; i < graph.V(); i++) {
                distTo[i] = Double.MAX_VALUE;
            }
            distTo[source] = 0.0;

            TopologicalSort topologicalSort = new TopologicalSort(graph);
            for (Integer u : topologicalSort.reversePostOrder()) {
                relax(u);
            }
        }


    }

    private void relax(Integer u) {
        if (distTo[u] == Double.MAX_VALUE){
            return;
        }
        for (DirectedWeightedEdge edge : graph.adj(u)) {
            int v = edge.to();
            if (distTo[u] + edge.weight() < distTo[v]){
                distTo[v] = distTo[u] + edge.weight();
                edgeTo[v] = edge;
            }
        }
    }

    public Iterable<DirectedWeightedEdge> pathTo(int u){
        Deque<DirectedWeightedEdge> list = new ArrayDeque<>();
        for (DirectedWeightedEdge edge = edgeTo[u]; edge != null; edge = edgeTo[edge.from()]){
            list.add(edge);
        }
        return list;
    }

    private String pathToString(int u){
        double w = 0.0;
        StringBuilder sb = new StringBuilder();
        sb.append("pathTo: ").append(u).append(" ");
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
        String url = "https://algs4.cs.princeton.edu/44sp/tinyEWDAG.txt";
        DirectedWeightedGraph graph = GraphGenerator.directedWeightedGraph(url);
        AcyclicSP acyclicSP = new AcyclicSP(graph, 5);
        for (int i = 0; i < graph.V(); i++) {
            System.out.println(acyclicSP.pathToString(i));
        }
    }
}
