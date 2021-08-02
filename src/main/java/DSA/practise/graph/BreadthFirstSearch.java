package DSA.practise.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch implements Paths {
    private Graph graph;
    private final int src;
    private final boolean[] visited;
    private final int[] distTo;
    private final Integer[] pathTo;

    public BreadthFirstSearch(Graph graph, int src) {
        this.graph = graph;
        this.src = src;
        visited = new boolean[graph.V()];
        distTo = new int[graph.V()];
        pathTo = new Integer[graph.V()];
        bfs();
    }

    private void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        visited[src] = true;
        distTo[src] = 0;
        pathTo[src] = src;
        queue.add(src);
        while (!queue.isEmpty()){
            Integer removed = queue.remove();
            for (Integer neighbor : graph.adj(removed)) {
                if (!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    distTo[neighbor] = distTo[removed] + 1;
                    pathTo[neighbor] = removed;
                }
            }

        }
    }


    @Override
    public boolean hasPathTo(int v) {
        return pathTo[v] != null;
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int curr = v; curr != pathTo[curr]; curr = pathTo[curr]){
            deque.add(curr);
        }
        deque.add(src);
        return deque;
    }
}
