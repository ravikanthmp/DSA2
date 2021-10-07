package DSA.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q261 {


    class Graph{
        int V;
        List<Integer>[] adj;
        public Graph(int n, int[][] edges) {
            V = n;
            adj = new LinkedList[V];
            for (int i = 0; i < adj.length; i++) {
                adj[i] = new LinkedList<>();
            }
            for (int[] edge : edges) {
                adj[edge[0]].add(edge[1]);
                adj[edge[1]].add(edge[0]);
            }
        }

        public Iterable<Integer> adj(int i){
            return adj[i];
        }
    }

    public boolean validTree(int n, int[][] edges) {
        Graph graph = new Graph(n, edges);
        boolean[] visited = new boolean[n];

        if(hasCycle(0, 0, graph, visited)){
            return false;
        }
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(int u, int parent ,Graph G, boolean[] visited){
        visited[u] = true;
        for (Integer v : G.adj(u)) {
            if (!visited[v]){
                boolean x= hasCycle(v, u, G, visited);
                if(x){
                    return true;
                }
            }else if (v != parent){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Q261 test = new Q261();
        int n = 4;
        int[][] edges = {{0, 1}, {2, 3}};
        System.out.println(test.validTree(n, edges));
    }
}
