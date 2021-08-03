package DSA.practise.queue;

import DSA.practise.graph.GraphGenerator;
import DSA.practise.graph.PrimMST;
import DSA.practise.graph.WeightedEdge;
import DSA.practise.graph.WeightedGraph;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimMSTTest {

    @Test
    void mstTiny() throws Exception{
        String tinyGraph = "https://algs4.cs.princeton.edu/43mst/tinyEWG.txt";
        WeightedGraph weightedGraph = GraphGenerator.weightedGraph(tinyGraph);

        PrimMST primMST = new PrimMST();
        List<WeightedEdge> mst = primMST.mst(weightedGraph);

        // mst weight
        double w = 0.0;
        for (WeightedEdge weightedEdge : mst) {
            w += weightedEdge.weight();
        }

        assertEquals(1.8, w, 0.01);

    }

    @Test
    void mstMedium() throws Exception{
        String tinyGraph = "https://algs4.cs.princeton.edu/43mst/mediumEWG.txt";
        WeightedGraph weightedGraph = GraphGenerator.weightedGraph(tinyGraph);

        PrimMST primMST = new PrimMST();
        List<WeightedEdge> mst = primMST.mst(weightedGraph);

        // mst weight
        double w = 0.0;
        for (WeightedEdge weightedEdge : mst) {
            w += weightedEdge.weight();
        }

        assertEquals(10.46, w, 0.01);

    }

    @Test
    void mstLarge() throws Exception{
        String tinyGraph = "https://algs4.cs.princeton.edu/43mst/largeEWG.txt";
        WeightedGraph weightedGraph = GraphGenerator.weightedGraph(tinyGraph);

        PrimMST primMST = new PrimMST();
        List<WeightedEdge> mst = primMST.mst(weightedGraph);

        // mst weight
        double w = 0.0;
        for (WeightedEdge weightedEdge : mst) {
            w += weightedEdge.weight();
        }

        assertEquals(647.6, w, 0.1);

    }

}