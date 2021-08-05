package DSA.practise.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {
    private DirectedWeightedGraph directedWeightedGraph;
    private DiGraph diGraph;
    private boolean hasCycle;
    private boolean[] visited;
    private int[] edgeTo;
    LinkedList<Integer> postOrder;

    public TopologicalSort(DiGraph diGraph) {
        this.diGraph = diGraph;
        visited = new boolean[diGraph.V()];
        edgeTo =  new int[diGraph.V()];
        postOrder = new LinkedList<>();
        DiGraphCycleDetection cycleDetection = new DiGraphCycleDetection(diGraph);
        this.hasCycle = cycleDetection.hasCycle();
        if (!hasCycle){
            for (int i = 0; i < diGraph.V(); i++) {
                if (!visited[i]){
                    dfs(diGraph, i);
                }
            }
        }


    }

    public TopologicalSort(DirectedWeightedGraph diGraph) {
        this.directedWeightedGraph = diGraph;
        visited = new boolean[diGraph.V()];
        edgeTo =  new int[diGraph.V()];
        postOrder = new LinkedList<>();
        for (int i = 0; i < diGraph.V(); i++) {
            if (!visited[i]){
                dfs(directedWeightedGraph, i);
            }
        }


    }
    private void dfs(DiGraph diGraph, int u) {
        visited[u] = true;
        for(int v : diGraph.adj(u)){
            if (!visited[v]){
                dfs(diGraph, v);
                edgeTo[v] = u;
            }
        }
        postOrder.add(u);
    }

    private void dfs(DirectedWeightedGraph directedWeightedGraph, int u) {
        visited[u] = true;
        for(DirectedWeightedEdge edge : directedWeightedGraph.adj(u)){
            int v = edge.to();
            if (!visited[v]){
                dfs(directedWeightedGraph, v);
                edgeTo[v] = u;
            }
        }
        postOrder.add(u);
    }

    public Iterable<Integer> reversePostOrder() {
        if (hasCycle){
            throw new RuntimeException("No topological sort as the Digraph has cycle.");
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for (Integer v : postOrder) {
            stack.push(v);
        }
        return stack;
    }

    public static void main(String[] args) throws Exception{
        String url = "https://algs4.cs.princeton.edu/42digraph/tinyDG.txt";
        DiGraph diGraph = GraphGenerator.diGraph(url);

        StringBuilder sb = new StringBuilder();
        // Reachability
        TopologicalSort topologicalSort = new TopologicalSort(diGraph );

        System.out.println(topologicalSort.reversePostOrder());
    }
}
