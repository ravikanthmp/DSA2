package DSA.practise.graph.sp;

import DSA.practise.graph.DirectedWeightedGraph;
import DSA.practise.graph.GraphGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcyclicSPTest {

    @Test
    public void testTiny() throws Exception{
        String url = "https://algs4.cs.princeton.edu/44sp/tinyEWDAG.txt";
        DirectedWeightedGraph directedWeightedGraph = GraphGenerator.directedWeightedGraph(url);
        AcyclicSP acyclicSP = new AcyclicSP(directedWeightedGraph, 5);
        Assertions.assertEquals(acyclicSP.pathWeight(1), 0.32, 0.01);
    }
}