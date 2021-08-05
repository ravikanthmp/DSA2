package DSA.practise.graph;

import java.util.ArrayList;
import java.util.List;

public class Cycle {

    private DirectedWeightedGraph directedWeightedGraph;
    private boolean[] visited;
    private Integer[] pathTo;
    private int[] ids;
    private Graph graph;
    private List<Integer> cycle;
    private boolean[] onStack;

    public Cycle(Graph graph) {
        this.graph = graph;
        this.visited =  new boolean[graph.V()];
        this.pathTo = new Integer[graph.V()];
        this.ids = new int[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
            if (!visited[i]){
                dfs(graph, i, -1, i);
            }
        }
    }

    public Cycle(DirectedWeightedGraph directedWeightedGraph) {
        this.directedWeightedGraph = directedWeightedGraph;
        this.visited =  new boolean[directedWeightedGraph.V()];
        this.pathTo = new Integer[directedWeightedGraph.V()];
        this.ids = new int[directedWeightedGraph.V()];
        this.onStack = new boolean[directedWeightedGraph.V()];
        for (int i = 0; i < directedWeightedGraph.V(); i++) {
            if (!visited[i]){
                dfs(directedWeightedGraph, i, -1, i);
            }
        }
    }

    private void dfs(Graph graph, int v, int parent, int component){

        visited[v] = true;
        pathTo[v] = parent;
        ids[v] = component;
        for (int w : graph.adj(v)){
            if (cycle != null){
                return;
            }
            if (!visited[w]){
                dfs(graph, w, v, component);
            }else if(w != parent){
                cycle = new ArrayList<>();
                cycle.add(w);
                for (int curr = v; curr != w ; curr = pathTo[curr]) {
                    System.out.println("curr = " + curr + " patToCurr = " + pathTo[curr]);
                    cycle.add(curr);
                }
                cycle.add(w);

            }
        }
    }

    private void dfs(DirectedWeightedGraph directedWeightedGraph, int v, int parent, int component){

        visited[v] = true;
        pathTo[v] = parent;
        ids[v] = component;
        onStack[v] = true;
        for (DirectedWeightedEdge edge : directedWeightedGraph.adj(v)){
            int w = edge.to();
            if (cycle != null){
                return;
            }
            if (!visited[w]){
                dfs(directedWeightedGraph, w, v, component);
            }else if(w != parent && onStack[w]){
                cycle = new ArrayList<>();
                cycle.add(w);
                for (int curr = v; curr != w ; curr = pathTo[curr]) {
                    System.out.println("curr = " + curr + " patToCurr = " + pathTo[curr]);
                    cycle.add(curr);
                }
                cycle.add(w);

            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle(){
        return cycle != null;
    }

    public Iterable<Integer> cycle(){
        return cycle;
    }
}
