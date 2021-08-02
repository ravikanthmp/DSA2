package DSA.practise.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {
    private DiGraph diGraph;
    private final boolean hasCycle;
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
                    dfs(i);
                }
            }
        }


    }

    private void dfs(int u) {
        visited[u] = true;
        for(int v : diGraph.adj(u)){
            if (!visited[v]){
                dfs(v);
                edgeTo[v] = u;
            }
        }
        postOrder.add(u);
    }

    public Iterable<Integer> reversePostOrder() {
        if (hasCycle){
            throw new RuntimeException("No topological sort as the Digraph has cycle.");
        }
        Stack<Integer> stack = new Stack<>();
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
