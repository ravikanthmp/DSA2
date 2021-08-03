package DSA.practise.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KruskalMSTTest {

    @Test
    public void testTiny() throws Exception{
        WeightedGraph weightedGraph =
                GraphGenerator.weightedGraph("https://algs4.cs.princeton.edu/43mst/tinyEWG.txt");
        KruskalMST kruskalMST = new KruskalMST(weightedGraph);
        Assertions.assertEquals(kruskalMST.weight(), 1.81, 0.1);
    }

    @Test
    public void testMedium() throws Exception{
        WeightedGraph weightedGraph =
                GraphGenerator.weightedGraph("https://algs4.cs.princeton.edu/43mst/mediumEWG.txt");
        KruskalMST kruskalMST = new KruskalMST(weightedGraph);
        Assertions.assertEquals(kruskalMST.weight(), 10.46, 0.1);
    }

}