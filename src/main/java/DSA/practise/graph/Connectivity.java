package DSA.practise.graph;

import java.util.*;

public class Connectivity {
    private final Graph graph;
    private boolean[] visited;
    private int[] ids;
    private int numComponents;

    public Connectivity(Graph graph) {
        this.graph = graph;
        this.ids = new int[graph.V()];
        this.visited = new boolean[graph.V()];
        int id = 0;
        for (int i = 0; i < graph.V(); i++) {
            if (!visited[i]){
                dfs(i, id);
                id++;
            }
        }
        numComponents = id;
    }

    private void dfs(int src, int id){

        LinkedList<Integer> queue = new LinkedList<>();

        queue.addFirst(src);
        visited[src] = true;
        while (!queue.isEmpty()){
            Integer first = queue.removeFirst();
            ids[first] = id;
            for(int w : graph.adj(first)){
                if (!visited[w]){
                    queue.addFirst(w);
//                    pathTo[w] = first;
                    visited[w] = true;
                }
            }
        }

//        visited[u] = true;
//        ids[u] = id;
//        for (int v : graph.adj(u)){
//            if (!visited[v]){
//                dfs(v, id);
//            }
//        }
    }

    public boolean connected(int u, int v){
        return ids[u] == ids[v];
    }

    public int count(){
        return numComponents;
    }

    public int id(int u){
        return ids[u];
    }

    @Override
    public String toString() {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < graph.V(); i++) {
            map.putIfAbsent(ids[i], new ArrayList<>());
            map.get(ids[i]).add(i);
        }
        return "Connectivity{}" + map.toString();
    }

    public static void main(String[] args) {

    }
}
