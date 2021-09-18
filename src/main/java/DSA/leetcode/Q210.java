package DSA.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q210 {

    class DirectedGraph{

        List<Integer>[] adj;
        private int V;

        public DirectedGraph(int v) {
            adj = new ArrayList[v];
            this.V = v;
            for (int i = 0; i < v; i++) {
                adj[i] = new ArrayList<>();
            }
        }

        public void addEdge(int u, int v){
            adj[u].add(v);
        }

        public Iterable<Integer> adj(int u){
            return adj[u];
        }

        public int V() {
            return V;
        }
    }

    enum VisitStatus{
        UNVISITED,
        IN_PROGRESS,
        FINISHED
    }

    private boolean isDAG(DirectedGraph graph){
        VisitStatus[] visited = new VisitStatus[graph.V()];
        Arrays.fill(visited, VisitStatus.UNVISITED);
        for (int i = 0; i < graph.V(); i++) {
            if (visited[i].equals(VisitStatus.UNVISITED)){
                boolean hasCycle = hasCycle(graph, i, i, visited);
                if (hasCycle){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasCycle(DirectedGraph graph, int v, int parent, VisitStatus[] visited){
        visited[v] = VisitStatus.IN_PROGRESS;

        for (int w : graph.adj(v)) {
            if (visited[w].equals(VisitStatus.UNVISITED)){
                boolean hasCycle = hasCycle(graph, w, v, visited);
                if (hasCycle){
                    return true;
                }
            }else if (visited[w].equals(VisitStatus.IN_PROGRESS) && (w != parent)){
                return true;
            }
        }
        visited[v] = VisitStatus.FINISHED;
        return false;
    }

    private List<Integer> topologicalSort(DirectedGraph graph){
        VisitStatus[] visited = new VisitStatus[graph.V()];
        List<Integer> postOrder = new ArrayList<>();
        Arrays.fill(visited, VisitStatus.UNVISITED);
        for (int i = 0; i < graph.V(); i++) {
            if (visited[i].equals(VisitStatus.UNVISITED)){
                visit(graph, visited, i, postOrder);
            }

        }
        return postOrder;
    }

    private void visit(DirectedGraph graph, VisitStatus[] visited,
                       int v,
                       List<Integer> postOrder){
        visited[v] = VisitStatus.IN_PROGRESS;

        for (int w : graph.adj(v)) {
            if (visited[w].equals(VisitStatus.UNVISITED)){
                visit(graph, visited, w, postOrder);
            }
        }

        postOrder.add(v);
        visited[v] = VisitStatus.FINISHED;
    }


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // convert to Directed Graph
        DirectedGraph directedGraph = new DirectedGraph(numCourses);
        for (int[] prerequisite : prerequisites) {
            int u = prerequisite[0];
            int v = prerequisite[1];
            directedGraph.addEdge(u, v);
        }
        if (isDAG(directedGraph)){
            List<Integer> list = topologicalSort(directedGraph);
            int[] res = new int[list.size()];
            int i = 0;
            for (Integer v : list) {
                res[i++]  = v;
            }
            return res;
        }else {
            return new int[0];
        }
    }

}
