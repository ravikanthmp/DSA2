package DSA.practise.graph;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class GraphGenerator {

    private static final String CHARSET_NAME = "UTF-8";

    public static Graph graph(String url) throws IOException, URISyntaxException {

        URL urlObj = new URL(url);
        InputStream inputStream = urlObj.openStream();
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(inputStream)
        );
        Integer V = Integer.valueOf(bufferedReader.readLine());
        Integer E = Integer.valueOf(bufferedReader.readLine());
        Graph graph = new Graph(V);
        for (int i = 0; i < E; i++) {
            String[] split = bufferedReader.readLine().split(" ");
            graph.addEdge(Integer.valueOf(split[0]), Integer.valueOf(split[1]));
        }
        return graph;
    }

    public static DiGraph diGraph(String url) throws IOException, URISyntaxException {

        URL urlObj = new URL(url);
        InputStream inputStream = urlObj.openStream();
        Scanner scanner  = new Scanner(new BufferedInputStream(inputStream), CHARSET_NAME);

        Integer V = scanner.nextInt();
        Integer E = scanner.nextInt();
        DiGraph graph = new DiGraph(V);
        for (int i = 0; i < E; i++) {
            graph.addEdge(scanner.nextInt(), scanner.nextInt());
        }
        return graph;
    }

    public static DirectedWeightedGraph directedWeightedGraph(String url) throws IOException, URISyntaxException {

        URL urlObj = new URL(url);
        InputStream inputStream = urlObj.openStream();
        Scanner scanner  = new Scanner(new BufferedInputStream(inputStream), CHARSET_NAME);

        Integer V = scanner.nextInt();
        Integer E = scanner.nextInt();
        DirectedWeightedGraph graph = new DirectedWeightedGraph(V);
        for (int i = 0; i < E; i++) {
            graph.addEdge(scanner.nextInt(), scanner.nextInt(), scanner.nextDouble());
        }
        return graph;
    }

    public static WeightedGraph weightedGraph(String url) throws IOException, URISyntaxException {

        URL urlObj = new URL(url);
        InputStream inputStream = urlObj.openStream();
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(inputStream)
        );
        Integer V = Integer.valueOf(bufferedReader.readLine());
        Integer E = Integer.valueOf(bufferedReader.readLine());
        WeightedGraph weightedGraph = new WeightedGraph(V);
        for (int i = 0; i < E; i++) {
            String[] split = bufferedReader.readLine().split(" ");
            weightedGraph.addEdge(Integer.valueOf(split[0]), Integer.valueOf(split[1]), Double.valueOf(split[2]));
        }
        return weightedGraph;
    }

    public static WeightedGraph tinyWeightedGraph() throws IOException, URISyntaxException {
        String url = "https://algs4.cs.princeton.edu/43mst/tinyEWG.txt";
        return weightedGraph(url);
    }
    public static void main(String[] args) {
        String url = "https://algs4.cs.princeton.edu/43mst/tinyEWG.txt";
        try {
            WeightedGraph weightedGraph = weightedGraph(url);
            for (int i = 0; i < weightedGraph.V(); i++) {
                System.out.println(weightedGraph.adj(i));
            }
        } catch (IOException e) {
            System.out.printf("shit broke");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

}
