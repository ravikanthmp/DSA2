package DSA.practise.graph;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class Kosaraju {

    private final DiGraph diGraph;
    private boolean[] visited;
    private int[] ids;
    private final int components;

    public Kosaraju(DiGraph diGraph) {
        this.diGraph = diGraph;
        visited = new boolean[diGraph.V()];
        ids = new int[diGraph.V()];

        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(diGraph.reverse());

        int comp = 0;
        for (Integer u : depthFirstOrder.reversePostOrder()) {
            if (!visited[u]){
                dfs(u, comp);
                comp++;
            }
        }
        components = comp;
    }

    private void dfs(int u, int comp){
        visited[u] = true;
        ids[u] = comp;
        for (Integer v : diGraph.adj(u)) {
            if (!visited[v]){
                dfs(v, comp);
            }
        }
    }

    public int numComponents(){
        return components;
    }

    @Override
    public String toString() {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < diGraph.V(); i++) {
            map.putIfAbsent(ids[i], new ArrayList<>());
            map.get(ids[i]).add(i);
        }
        return "Kosraju Connectivity{}" + map;
    }


    public static void main(String[] args) throws IOException, URISyntaxException {

        String url = "https://algs4.cs.princeton.edu/42digraph/tinyDG.txt";
        Kosaraju kosaraju = new Kosaraju(GraphGenerator.diGraph(url));
        System.out.println(kosaraju.numComponents());
        System.out.println(kosaraju);
    }
}
