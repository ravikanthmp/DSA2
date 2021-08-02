package DSA.practise.graph;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class CycleTest {

    @Test
    public void testTiny() throws IOException, URISyntaxException {
        String url = "https://algs4.cs.princeton.edu/41graph/tinyG.txt";
        Graph graph = GraphGenerator.graph(url);
        Cycle cycle = new Cycle(graph);
        System.out.println(cycle.cycle());
    }

    @Test
    public void testMedium() throws IOException, URISyntaxException {
        String url = "https://algs4.cs.princeton.edu/41graph/mediumG.txt";
        Graph graph = GraphGenerator.graph(url);
        Cycle cycle = new Cycle(graph);
        System.out.println(cycle.cycle());
    }

    @Test
    public void testLarge() throws IOException, URISyntaxException {
        String url = "https://algs4.cs.princeton.edu/41graph/largeG.txt";
        Graph graph = GraphGenerator.graph(url);
        Cycle cycle = new Cycle(graph);
        System.out.println(cycle.cycle());
    }
}