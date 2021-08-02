package DSA.practise.graph;

import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectivityTest {

    @Test
    public void testTiny() throws Exception{
        String url = "https://algs4.cs.princeton.edu/41graph/tinyG.txt";
        Graph graph = GraphGenerator.graph(url);
        Connectivity connectivity = new Connectivity(graph);
        assertEquals(3, connectivity.count());
    }

    @Test
    public void testMedium() throws Exception{
        String url = "https://algs4.cs.princeton.edu/41graph/mediumG.txt";
        Graph graph = GraphGenerator.graph(url);
        Connectivity connectivity = new Connectivity(graph);
        assertEquals(1, connectivity.count());
    }

    @Ignore
    @Test
    public void testLarge() throws Exception{
        String url = "https://algs4.cs.princeton.edu/41graph/largeG.txt";
        Graph graph = GraphGenerator.graph(url);
        Connectivity connectivity = new Connectivity(graph);
        assertEquals(1, connectivity.count());
    }


}