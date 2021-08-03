package DSA.practise.graph;

import DSA.practise.queue.PriorityQueue;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class PrimsLazyMST {
    private WeightedGraph graph;
    private List<WeightedEdge> edges;
    private boolean[] marked;

    public PrimsLazyMST(WeightedGraph graph) {
        this.graph = graph;
        marked = new boolean[graph.V()];
        edges = new ArrayList<>();
        mst();
    }

    public void mst(){
        PriorityQueue<WeightedEdge> pq = new PriorityQueue<>();
        int random = (int) (Math.random() * graph.V());
        visit(random, pq);
        while (edges.size() != graph.V() - 1){
            WeightedEdge remove = pq.remove();
            if (marked[remove.u] && marked[remove.v]){
                continue;
            }
            edges.add(remove);

            if (!marked[remove.u]){
                visit(remove.u, pq);
            }

            if (!marked[remove.v]){
                visit(remove.v, pq);
            }
        }
    }

    private void visit(int u, PriorityQueue<WeightedEdge> pq ){
        marked[u] = true;
        for (WeightedEdge edge : graph.adj(u)) {
            int v = edge.other(u);
            if (!marked[v]){
                pq.add(edge);
            }
        }
    }

    public double weight(){
        double sum = 0.0;
        for (WeightedEdge weightedEdge : edges) {
            sum += weightedEdge.weight();
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        WeightedGraph weightedGraph =
                GraphGenerator.weightedGraph("https://algs4.cs.princeton.edu/43mst/mediumEWG.txt");
        PrimsLazyMST primsLazyMST = new PrimsLazyMST(weightedGraph);
        for (WeightedEdge edge : primsLazyMST.edges) {
            System.out.println(edge);
        }
        System.out.println(primsLazyMST.weight());
    }
}
