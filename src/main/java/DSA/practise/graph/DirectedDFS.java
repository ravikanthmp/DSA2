package DSA.practise.graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class DirectedDFS {
    private DiGraph diGraph;
    private int src;
    private boolean[] visited;
    private int[] edgeTo;

    public DirectedDFS(DiGraph diGraph, int src) {
        this.diGraph = diGraph;
        this.src = src;
        visited = new boolean[diGraph.V()];
        edgeTo = new int[diGraph.V()];
        edgeTo[src] = -1;
        dfs(src);
    }

    private void dfs(int u) {
        visited[u] = true;
        for(int v : diGraph.adj(u)){
            if (!visited[v]){
                dfs(v);
                edgeTo[v] = u;
            }
        }
    }

    public boolean hasPathTo(int u){
        return visited[u];
    }

    public Iterable<Integer> pathTo(int u){
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = u; i > 0 ; i = edgeTo[i]) {
            deque.add(i);
        }
        return deque;
    }

    public static void main(String[] args) throws Exception{
        String url = "https://algs4.cs.princeton.edu/42digraph/tinyDG.txt";
        DiGraph diGraph = GraphGenerator.diGraph(url);

        StringBuilder sb = new StringBuilder();
        // Reachability
        DirectedDFS directedDFS = new DirectedDFS(diGraph, 2    );
        for (int i = 0; i < diGraph.V(); i++) {
            if (directedDFS.hasPathTo(i)){
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }
}
