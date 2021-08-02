package DSA.practise.graph;

import java.util.LinkedList;
import java.util.Queue;

public class DepthFirstSearchNonRecursive {
    private boolean[] visited;
    private Integer[] pathTo;
    private Graph graph;
    private int src;

    public DepthFirstSearchNonRecursive(Graph graph, int src) {
        visited = new boolean[graph.V()];
        pathTo = new Integer[graph.V()];
        this.graph = graph;
        this.src = src;
        pathTo[src] = src;
        dfsNonRecursive();
    }

    private void dfsNonRecursive(){
        LinkedList<Integer> queue = new LinkedList<>();

        queue.addFirst(src);
        visited[src] = true;
        while (!queue.isEmpty()){
            Integer first = queue.removeFirst();
            for(int w : graph.adj(first)){
                if (!visited[w]){
                    queue.addFirst(w);
                    pathTo[w] = first;
                    visited[w] = true;
                }
            }
        }
    }
}
