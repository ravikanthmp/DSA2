package DSA.practise.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepthFirstSearchTest {

    @Test
    public void testTiny() throws Exception{
//        https://algs4.cs.princeton.edu/41graph/DepthFirstSearch.java.html
        Graph graph = GraphGenerator.graph("https://algs4.cs.princeton.edu/41graph/tinyG.txt");
        DepthFirstSearch dfs = new DepthFirstSearch(graph, 9);
        List<Integer> integers = List.of(9, 10, 11, 12);
        for (Integer reachable : integers) {
            Assertions.assertTrue(dfs.hasPathTo(reachable));
        }
    }

    @Test
    public void testTiny2() throws Exception{
//        https://algs4.cs.princeton.edu/41graph/DepthFirstSearch.java.html
        Graph graph = GraphGenerator.graph("https://algs4.cs.princeton.edu/41graph/tinyG.txt");
        DepthFirstSearch dfs = new DepthFirstSearch(graph, 0);
        List<Integer> integers = List.of(0, 1, 2, 3, 4, 5, 6);
        for (Integer reachable : integers) {
            Assertions.assertTrue(dfs.hasPathTo(reachable));
        }
    }
}