package DSA.practise.graph;

import java.util.ArrayList;
import java.util.List;

public class Cycle {

    private boolean[] visited;
    private Integer[] pathTo;
    private Graph graph;
    private List<Integer> cycle;

    public Cycle(Graph graph) {
        this.graph = graph;
        this.visited =  new boolean[graph.V()];
        this.pathTo = new Integer[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
            if (!visited[i]){
                dfs(i, -1);
            }
        }
    }

    private void dfs(int v, int parent){

        visited[v] = true;
        pathTo[v] = parent;
        for (int w : graph.adj(v)){
            if (cycle != null){
                return;
            }
            if (!visited[w]){
                dfs(w, v);
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

    public boolean hasCycle(){
        return cycle != null;
    }

    public Iterable<Integer> cycle(){
        return cycle;
    }
}
