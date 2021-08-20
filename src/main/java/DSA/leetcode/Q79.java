package DSA.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Q79 {

    private boolean[][] visited;
    private char[][] board;
    private String word;
    private boolean done;

    public boolean exist(char[][] board, String word) {

        this.board = board;
        this.word = word;
        this.visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean found = find(Point.from(i, j), 0);
                if (found){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean find(Point p, int idx) {

        if (idx == word.length()){
            return true;
        }else {
            if (board[p.i][p.j] == word.charAt(idx)){

                if (idx == word.length() - 1){
                    return true;
                }
                // mark
                visited[p.i][p.j] = true;

                // recurse one step further
                for (Point neighbor : neighbors(p)){
                    if (!visited[neighbor.i][neighbor.j]){
                        boolean ans = find(neighbor, idx + 1);
                        if (ans){
                            return true;
                        }
                    }
                   
                }

                // unmark
                visited[p.i][p.j] = false;

                return false;
            }else {
                return false;
            }

        }
    }

    private List<Point> neighbors(Point point){
        int i = point.i;
        int j = point.j;

        List<Point> list =  List.of(
                Point.from(i, j - 1),
                Point.from(i, j + 1),
                Point.from(i - 1, j),
                Point.from(i + 1, j)
        );


        return list.stream().filter(p -> valid(p)).collect(Collectors.toUnmodifiableList());
    }

    private boolean valid(Point point){
        int i = point.i;
        int j = point.j;
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }


    static class Point{
        int i;
        int j;

        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        static Point from(int i, int j){
            return new Point(i, j);
        }
    }

    public static void main(String[] args) {
        char[][] arr = {{'a'}};
        Q79 test = new Q79();
        System.out.println(test.exist(arr, "a"));
                
    }
}
