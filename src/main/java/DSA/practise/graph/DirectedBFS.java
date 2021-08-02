package DSA.practise.graph;

import com.google.common.collect.Lists;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DirectedBFS {
    private DiGraph diGraph;
    private Iterable<Integer> sources;
    private int[] distTo;
    private boolean[] visited;
    private int[] pathTo;

    public DirectedBFS(DiGraph diGraph, int v) {
        this.sources = Lists.newArrayList(v);
        this.distTo = new int[diGraph.V()];
        this.visited = new boolean[diGraph.V()];
        this.pathTo = new int[diGraph.V()];
    }

    public DirectedBFS(DiGraph diGraph, Iterable<Integer> src) {
        this.diGraph = diGraph;
        this.sources = src;
        this.distTo = new int[diGraph.V()];
        this.visited = new boolean[diGraph.V()];
    }

    private void bsf(Iterable<Integer> src){
        LinkedList<Integer> queue = new LinkedList<>();
        for (Integer u : src) {
            queue.add(u);
            distTo[u]  = 0;
            visited[u] = true;
            pathTo[u] = -1;
        }

        while (!queue.isEmpty()){
            Integer u = queue.remove();
            for (int w : diGraph.adj(u)){
                if (!visited[w]){
                    visited[w] = true;
                    distTo[w]  = distTo[u] + 1;
                    pathTo[w]  = u;
                }
            }
        }
    }

    public boolean hasPathTo(int u){
        return visited[u];
    }

    public Iterable<Integer> pathTo(int u){
        Deque<Integer> deque = new ArrayDeque<>();
        for (int curr = u; curr != -1; curr = pathTo[curr]){
            deque.add(curr);
        }
        return deque;
    }

    public static void main(String[] args) {

    }
}
