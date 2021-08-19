package DSA.practise.progPatterns.recursion;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class NumberOfIslandsBFS {

    private boolean[][] visited ;
    private int numOfComponents = 0;
    private char[][] grid;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        int M = grid.length;
        int N = grid[0].length;
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == '1' && !visited[i][j]){
                    numOfComponents++;
                    bfs(i, j);
                }
            }
        }
        return numOfComponents;
    }

    private void bfs(int i, int j){
        Queue<Point> queue = new LinkedList<>();
        queue.add(Point.of(i, j));
        visited[i][j] = true;

        while (!queue.isEmpty()){
            Point removed = queue.remove();
            for (Point neighbour : neighbours(removed)) {
                if (!visited(neighbour)){
                    visited[neighbour.i][neighbour.j]= true;
                    queue.add(neighbour);
                }
            }

        }
    }

    private boolean visited(Point neighbour) {
        return valid(neighbour) && visited[neighbour.i][neighbour.j];
    }

    static class Point {
        int i;
        int j;

        private Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        static Point of(int i, int j) {
            return new Point(i, j);
        }
    }
    
    private List<Point> neighbours(Point point) {
        int i = point.i;
        int j = point.j;
        List<Point> pointList = List.of(
                Point.of(i - 1, j),
                Point.of(i, j - 1),
                Point.of(i, j + 1),
                Point.of(i + 1, j)
        );
        return pointList.parallelStream().filter(this::valid).collect(Collectors.toUnmodifiableList());
    }

    private boolean valid(Point point) {
        int M = grid.length;;
        int N = grid[0].length;

        return point.i >= 0 && point.i < M && point.j >= 0 && point.j < N && grid[point.i][point.j] == '1';
    }


}
