package DSA.leetcode;

import java.util.*;
import java.util.stream.IntStream;

public class Q200 {


    class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return i == point.i && j == point.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    class UnionFind {
        private int[] comp;
        private int[] size;
        private Map<Point, Integer> map;

        public UnionFind(List<Point> points) {
            map = new HashMap<>();
            int N = points.size();
            comp = new int[N];
            size = new int[N];
            int i = 0;

            for (Point point : points) {
                map.put(point, i);
                comp[i] = i;
                size[i] = 1;
                i++;
            }
        }

        private int find(Point point) {
            int i = map.get(point);
            while (i != comp[i]) {
                i = comp[i];
            }
            return i;
        }

        public int numComponents() {
            return (int) IntStream.range(0, comp.length).filter(i -> comp[i] == i).count();
        }

        public void union(Point p1, Point p2) {
            int comp1 = find(p1);
            int comp2 = find(p2);

            if (comp1 == comp2){
                return;
            }
            int s1 = size[comp1];
            int s2 = size[comp2];

            if (s1 >= s2) {
                comp[comp2] = comp1;
                size[comp1] += s2;
            } else {
                comp[comp1] = comp2;
                size[comp2] += s1;
            }
        }
    }

    public int numIslands(char[][] grid) {

        int numOnes = 0;
        List<Point> list = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    list.add(new Point(i, j));
                }
            }
        }

        UnionFind uf = new UnionFind(list);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if(isValid(i, j, grid)){
                    if (isValid(i - 1, j, grid)) {
                        uf.union(new Point(i, j), new Point(i - 1, j));
                    }


                    if (isValid(i, j - 1, grid)) {
                        uf.union(new Point(i, j), new Point(i, j - 1));
                    }
                }

            }
        }


        return uf.numComponents();
    }

    private boolean isValid(int i, int j, char[][] grid) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length
                && grid[i][j] == '1';
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        Q200 test = new Q200();
        System.out.println(test.numIslands(grid));
    }
}
