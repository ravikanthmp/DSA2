package DSA.leetcode;

import java.util.*;

public class Q417 {

    private int[][] heights;

    class Point{
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return r == point.r && c == point.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }

    private Map<Point, Set<DestReached>> memo;
    private Set<Point> visited;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        visited = new HashSet<>();
        List<List<Integer>> results = new ArrayList<>();

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                Set<DestReached> check = check(i, j);
                if (check.contains(DestReached.PACIFIC) && check.contains(DestReached.ATLANTIC)){
                    results.add(List.of(i, j));
                }
            }
        }

        return results;
    }

    private Set<DestReached> check(int i, int j) {
        Point point = new Point(i, j);
        visited.add(point);
        Set<DestReached> results = new HashSet<>();
        for (Point neighbour : neighbours(point)) {
            if (!visited.contains(neighbour)){
                Set<DestReached> check = check(neighbour.r, neighbour.c);
                results.addAll(check);
            }
        }

        results.addAll(checkForPoint(point));


        visited.remove(point);

       return  results;

    }

    private List<Point> neighbours(Point point){

        List<Point> neighbours = new ArrayList<>();

        if (isValid(point.r - 1, point.c)){
            Point p = new Point(point.r - 1, point.c);
            if (canFlow(point, p)){
                neighbours.add(p);
            }
        }

        if (isValid(point.r + 1, point.c)){
            Point p = new Point(point.r + 1, point.c);
            if (canFlow(point, p)){
                neighbours.add(p);
            }
        }

        if (isValid(point.r, point.c - 1)){
            Point p = new Point(point.r, point.c - 1);
            if (canFlow(point, p)){
                neighbours.add(p);
            }
        }

        if (isValid(point.r, point.c + 1)){
            Point p = new Point(point.r, point.c + 1);
            if (canFlow(point, p)){
                neighbours.add(p);
            }
        }

        return neighbours;
    }

    private boolean isValid(int i, int j){
        return  (i >= 0 && i < heights.length && j >= 0 && j < heights[0].length);
    }

    enum DestReached{
        ATLANTIC,
        PACIFIC,
        NONE;
    }

    private Set<DestReached> checkForPoint(Point p){
        int r = p.r;
        int c = p.c;

        Set<DestReached> results = new HashSet<>();

        if (r == 0){
            results.add(DestReached.PACIFIC);
        }

        if (c == 0){
            results.add(DestReached.PACIFIC);
        }

        if (r == heights.length - 1){
            results.add(DestReached.ATLANTIC);
        }

        if (c == heights[0].length - 1){
            results.add(DestReached.ATLANTIC);
        }

        return results;
    }

    private boolean canFlow(Point p1, Point p2){
        return heights[p1.r][p1.c] >= heights[p2.r][p2.c];
    }

    public static void main(String[] args) {
        int[][] arr = {{10,10,10},{10,1,10},{10,10,10}};
        Q417 test = new Q417();
        System.out.println(test.pacificAtlantic(arr));
    }
}
