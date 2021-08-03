package DSA.practise.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimsLazyMSTTest {

    @Test
    public void testTiny() throws Exception{
        WeightedGraph weightedGraph =
                GraphGenerator.weightedGraph("https://algs4.cs.princeton.edu/43mst/tinyEWG.txt");
        PrimsLazyMST primsLazyMST = new PrimsLazyMST(weightedGraph);
        Assertions.assertEquals(primsLazyMST.weight(), 1.81, 0.1);
    }

    @Test
    public void testMedium() throws Exception{
        WeightedGraph weightedGraph =
                GraphGenerator.weightedGraph("https://algs4.cs.princeton.edu/43mst/mediumEWG.txt");
        PrimsLazyMST primsLazyMST = new PrimsLazyMST(weightedGraph);
        Assertions.assertEquals(primsLazyMST.weight(), 10.46, 0.1);
    }

}