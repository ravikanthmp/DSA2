package DSA.practise.graph.sp;

import DSA.practise.graph.DirectedWeightedGraph;
import DSA.practise.graph.GraphGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraSPTest {

    /*
    Time : O(E * log(V))
    Space : O(V)
     */

    @Test
    public void testTiny() throws Exception{
        String url = "https://algs4.cs.princeton.edu/44sp/tinyEWD.txt";
        DirectedWeightedGraph directedWeightedGraph = GraphGenerator.directedWeightedGraph(url);
        DijkstraSP sp = new DijkstraSP(directedWeightedGraph, 0);
        Assertions.assertEquals(sp.pathWeight(4), 0.38, 0.03);
        Assertions.assertEquals(sp.pathWeight(5), 0.73, 0.03);
    }

    @Test
    public void testMedium() throws Exception{
        String url = "https://algs4.cs.princeton.edu/44sp/mediumEWD.txt";
        DirectedWeightedGraph directedWeightedGraph = GraphGenerator.directedWeightedGraph(url);
        DijkstraSP sp = new DijkstraSP(directedWeightedGraph, 0);
        Assertions.assertEquals(sp.pathWeight(2), 0.65, 0.03);
    }
}