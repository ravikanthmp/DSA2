package DSA.practise.graph;

public class DiGraphCycleDetection {
    private DiGraph diGraph;
    private boolean[] visited;
    private boolean hasCycle;

    public DiGraphCycleDetection(DiGraph diGraph){
        this.diGraph = diGraph;
        this.visited = new boolean[diGraph.V()];
        for (int i = 0; i < diGraph.V(); i++) {
            if (!visited[i]){
                dfs(i, i);
            }
        }
    }

    private void dfs(int u, int p){
        visited[u] = true;
        for (Integer w : diGraph.adj(u)) {
            if (hasCycle){
                return;
            }
            if(!visited[w]){
                dfs(w, u);
            }else if (w != p){
                hasCycle = true;
            }
        }
    }

    public boolean hasCycle(){
        return hasCycle;
    }

}
