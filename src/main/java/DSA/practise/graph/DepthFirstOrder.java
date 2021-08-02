package DSA.practise.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class DepthFirstOrder {
    private DiGraph diGraph;
    private boolean[] visited;
    private int[] edgeTo;
    LinkedList<Integer> postOrder;

    public DepthFirstOrder(DiGraph diGraph) {
        this.diGraph = diGraph;
        visited = new boolean[diGraph.V()];
        edgeTo =  new int[diGraph.V()];
        postOrder = new LinkedList<>();

        for (int i = 0; i < diGraph.V(); i++) {
            if (!visited[i]){
                dfs(i);
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
        DepthFirstOrder topologicalSort = new DepthFirstOrder(diGraph );

        System.out.println(topologicalSort.reversePostOrder());
    }
}
