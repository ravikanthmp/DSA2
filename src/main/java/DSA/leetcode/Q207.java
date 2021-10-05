package DSA.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q207 {

    class DirectedGraph{
        private List<Integer>[] adj;

        public DirectedGraph(int numCourses, int[][] prerequisites) {
            adj = new LinkedList[numCourses];
            for (int i = 0; i < numCourses; i++) {
                adj[i] = new LinkedList<>();
            }

            for (int[] prerequisite : prerequisites) {
                int u = prerequisite[0];
                int v = prerequisite[1];

                adj[u].add(v);
            }
        }

        public Iterable<Integer> neighbours(int u){
            return adj[u];
        }
    }

    DirectedGraph graph;
    VisitStatus[] visited;
    int[] comp;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new DirectedGraph(numCourses, prerequisites);
        visited = new VisitStatus[numCourses];
        Arrays.fill(visited, VisitStatus.UNVISITED);
        comp = new int[numCourses];
        int x = 0;
        for (int i = 0; i < numCourses; i++) {
            if (visited[i].equals(VisitStatus.UNVISITED)){
                boolean ans =  hasCycle(i, i, x++);
                if (ans){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasCycle(int u, int parent, int component){
        visited[u] = VisitStatus.IN_PROGRESS;
        comp[u] = component;

        boolean ans = false;
        for(int w : graph.neighbours(u)){
            if (visited[w].equals(VisitStatus.UNVISITED)){
                ans =  hasCycle(w, u, component);
                if (ans){
                    break;
                }
            }else if (visited[w].equals(VisitStatus.IN_PROGRESS) && comp[w] == comp[parent]){
               ans = true;
               break;
            }
        }

        visited[u] = VisitStatus.FINISHED;
        return ans;

    }

    enum VisitStatus{
        UNVISITED,
        IN_PROGRESS,
        FINISHED;
    }
    public static void main(String[] args) {
//
    }
}
