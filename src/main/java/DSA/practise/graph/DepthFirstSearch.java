package DSA.practise.graph;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class DepthFirstSearch implements Paths {

    private final Graph graph;
    private boolean[] visited;
    private Integer[] pathTo;
    private final int src;

    public DepthFirstSearch(Graph graph, int src) {
        this.graph = graph;
        this.visited = new boolean[graph.V()];
        this.pathTo = new Integer[graph.V()];
        this.src = src;
        pathTo[src] = src;
        dfs(src);
    }

    @Override
    public boolean hasPathTo(int v) {
        return pathTo[v] != null;
    }

    @Override
    public Iterable<Integer> pathTo(int v) {

        if (pathTo[v] == null) {
            throw new RuntimeException("Path not found to " + v);
        }
        Deque<Integer> path = new ArrayDeque<>();
        for (int curr = v; curr != pathTo[curr]; curr = pathTo[curr]) {
            path.push(curr);
        }
        path.push(src);
        return path;
    }

    private void dfs(int v) {

        visited[v] = true;
        for (int neighbour : graph.adj(v)) {
            if (!visited[neighbour]) {
                pathTo[neighbour] = v;
                dfs(neighbour);
            }
        }
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        Graph graph = GraphGenerator.graph("https://algs4.cs.princeton.edu/41graph/tinyG.txt");
        DepthFirstSearch dfs = new DepthFirstSearch(graph, 9);
        for (int i = 0; i < graph.V(); i++) {
            if (dfs.hasPathTo(i)) {
                System.out.println(dfs.pathTo(i));
            }
        }
    }
}

