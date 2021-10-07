package DSA.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q323 {

    class Graph {
        int V;
        List<Integer>[] adj;

        public Graph(int n, int[][] edges) {
            V = n;
            adj = new LinkedList[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new LinkedList<>();
            }

            for (int[] edge : edges) {
                adj[edge[0]].add(edge[1]);
                adj[edge[1]].add(edge[0]);
            }
        }

        public Iterable<Integer> adj(int u) {
            return adj[u];
        }
    }

    int[] component;
    boolean[] visited;

    public int countComponents(int n, int[][] edges) {
        Graph graph = new Graph(n, edges);
        component = new int[n];
        visited = new boolean[n];
        int x = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, x++, graph);
            }
        }
        return x;
    }

    private void dfs(int u, int cmp, Graph graph) {
        visited[u] = true;
        component[u] = cmp;
        for (Integer v : graph.adj(u)) {
            if (!visited[v]) {
                dfs(v, cmp, graph);
            }
        }
    }

}
