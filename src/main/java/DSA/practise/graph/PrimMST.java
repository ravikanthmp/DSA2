package DSA.practise.graph;

import DSA.practise.queue.IndexedPriorityQueue;
import DSA.practise.stack.Stack;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PrimMST {

    class Node implements Comparable<Node> {
        private int vertex;
        private double distTo;
        private WeightedEdge edgeTo;

        public Node(int vertex){
            this.vertex = vertex;
            this.distTo = Integer.MAX_VALUE;
            this.edgeTo = null;
        }

        public Node(int vertex, double distTo, WeightedEdge edgeTo) {
            this.vertex = vertex;
            this.distTo = distTo;
            this.edgeTo = edgeTo;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(distTo, o.distTo);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return vertex == node.vertex;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(vertex);
        }
    }

    /**
     * Kruskal's MST
     * @param graph
     * @return
     */
    public List<WeightedEdge> mst(WeightedGraph graph){
        Stack<Node> stack = new Stack<>();
//        SinglyLinkedList<WeightedEdge> edges = new SinglyLinkedList<>();
        List<WeightedEdge> edges = new ArrayList<WeightedEdge>();
        IndexedPriorityQueue<Node> pq = new IndexedPriorityQueue<>();
        for (int i = 0; i < graph.V(); i++) {
            pq.add(new Node(i));
        }
        int start = 0;
        Integer index = pq.anyIndexOf(new Node(0));
        pq.set(index, new Node(0, 0, new WeightedEdge(0, 0, 0.0)));
        // there can be only one

        while (!pq.isEmpty()){
            Node nearestNode = pq.delete();
            stack.push(nearestNode);
            for (Object obj : graph.adj(nearestNode.vertex)) {
                WeightedEdge edge = (WeightedEdge) obj;
                int other = edge.other(nearestNode.vertex);
                Integer indexOfOther = pq.anyIndexOf(new Node(other));
                if (!Objects.isNull(indexOfOther) ){
                    Node node = pq.get(indexOfOther);
                    if (edge.weight() < node.distTo){
                        pq.set(indexOfOther, new Node(other,
                                edge.weight(), edge));
                    }
                }
            }

        }

        while (!stack.isEmpty()){
            Node pop = stack.pop();
            edges.add(pop.edgeTo);
        }

        return edges;
    }

    public static void main(String[] args) {
        try {
            WeightedGraph weightedGraph = GraphGenerator.weightedGraph("https://algs4.cs.princeton.edu/43mst/tinyEWG.txt");
            PrimMST primMST = new PrimMST();
            List<WeightedEdge> mst = primMST.mst(weightedGraph);

            // mst weight
            double w = 0.0;
            for (WeightedEdge weightedEdge : mst) {
                w += weightedEdge.weight();
            }

            for (WeightedEdge weightedEdge : mst) {
                System.out.println(weightedEdge);
            }
            System.out.println("MST wieght = " + w);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
