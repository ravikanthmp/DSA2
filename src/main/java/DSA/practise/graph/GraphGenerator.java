package DSA.practise.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class GraphGenerator {
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
