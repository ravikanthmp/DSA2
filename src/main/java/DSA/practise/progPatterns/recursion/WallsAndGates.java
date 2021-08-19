package DSA.practise.progPatterns.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WallsAndGates {

    private int[][] rooms;
    private boolean[][] visited;

    public void wallsAndGates(int[][] rooms) {

        this.rooms = rooms;
        visited = new boolean[rooms.length][rooms[0].length];

        Queue<Point> queue = new LinkedList<>();

        // init roots
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    visited[i][j] = true;
                    queue.add(Point.of(i, j));
                }
            }
        }

        int step = -1;

        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            ;
            for (int i = 0; i < size; i++) {
                Point removed = queue.remove();
                rooms[removed.i][removed.j] = step;
                for (Point neighbour : neighbours(removed)) {
                    if (!visited(neighbour)) {
                        visited[neighbour.i][neighbour.j] = true;
                        queue.add(neighbour);
                    }
                }
            }
        }
    }

    private boolean visited(Point point) {
        return visited[point.i][point.j];
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
        int M = rooms.length;
        ;
        int N = rooms[0].length;

        return point.i >= 0 && point.i < M && point.j >= 0 && point.j < N && rooms[point.i][point.j] != -1;
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
}
