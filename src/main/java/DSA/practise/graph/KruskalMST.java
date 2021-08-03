package DSA.practise.graph;

import DSA.practise.queue.PriorityQueue;
import DSA.practise.unionfind.UF;
import DSA.practise.unionfind.WeightedUnionFindWithPathCompression;
import java.util.ArrayList;
import java.util.List;

public class KruskalMST {

    private List<WeightedEdge> edge;

    /*
    Time : O(E * log E)
    Space : O(E)
     */
    public KruskalMST(WeightedGraph graph){
        edge = new ArrayList<>();
        PriorityQueue<WeightedEdge> pq = new PriorityQueue<>();
        for (int i = 0; i < graph.V(); i++) {
            for (WeightedEdge weightedEdge : graph.adj(i)) {
                pq.add(weightedEdge);
            }
        }
        UF uf = new WeightedUnionFindWithPathCompression(graph.V());

        while (!pq.isEmpty()){
            WeightedEdge removed = pq.remove();
            if (!uf.connected(removed.u, removed.v)){
                edge.add(removed);
                uf.union(removed.u, removed.v);
            }
        }
    }

    public Iterable<WeightedEdge> edges(){
        return edge;
    }

    public double weight(){
        double sum = 0.0;
        for (WeightedEdge weightedEdge : edge) {
            sum += weightedEdge.weight();
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        WeightedGraph weightedGraph =
                GraphGenerator.weightedGraph("https://algs4.cs.princeton.edu/43mst/tinyEWG.txt");
        KruskalMST kruskalMST = new KruskalMST(weightedGraph);
        int size = 0;
        for (WeightedEdge edge : kruskalMST.edges()) {
            System.out.println(edge);
            size++;
        }
        assert size == weightedGraph.V() - 1;

        System.out.println(kruskalMST.weight());
    }
}
