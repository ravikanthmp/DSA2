package DSA.practise.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFSOfficial {
    private boolean[] marked;          // marked[v] = has v been marked in dfs?
    private int[] pre;                 // pre[v]    = preorder  number of v
    private int[] post;                // post[v]   = postorder number of v
    private Queue<Integer> preorder;   // vertices in preorder
    private Queue<Integer> postorder;  // vertices in postorder
    private int preCounter;            // counter or preorder numbering
    private int postCounter;           // counter for postorder numbering

    /**
     * Determines a depth-first order for the digraph {@code G}.
     * @param G the digraph
     */
    public DFSOfficial(DiGraph G) {
        pre    = new int[G.V()];
        post   = new int[G.V()];
        postorder = new LinkedList<>();

        marked    = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v]) dfs(G, v);

    }

    // run DFS in digraph G from vertex v and compute preorder/postorder
    private void dfs(DiGraph G, int v) {
        marked[v] = true;
        pre[v] = preCounter++;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        postorder.add(v);
        post[v] = postCounter++;
    }

    public Iterable<Integer> post() {
        return postorder;
    }

    public Iterable<Integer> reversePost() {
        Stack<Integer> reverse = new Stack<Integer>();
        for (int v : postorder)
            reverse.push(v);
        return reverse;
    }


    public static void main(String[] args) throws Exception {
        String url = "https://algs4.cs.princeton.edu/42digraph/tinyDG.txt";
        DiGraph diGraph = GraphGenerator.diGraph(url);
        DepthFirstOrder dfs = new DepthFirstOrder(diGraph);
        StringBuilder sb = new StringBuilder();
        for (int v : dfs.reversePostOrder()) {
            sb.append(v).append(" ");
        }

        System.out.println(sb);

    }

}
