package DSA.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q79 {


    private char[][] board;
    private String word;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (!visited[row][col] && search(row, col, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(int row, int col, int idx) {

        visited[row][col] = true;
        char curr = word.charAt(idx);
        boolean result = false;
        if (board[row][col] == curr){
            if (idx == word.length() - 1){
                return true;
            }
            for (int[] neighbor : neighbors(row, col)) {
                if (!visited[neighbor[0]][neighbor[1]]){
                    boolean subRes = search(neighbor[0], neighbor[1], idx + 1);
                    if (subRes){
                        result = true;
                        break;
                    }
                }
            }

        }else {
            result =  false;
        }

        visited[row][col] = false;
        return result;

    }

    List<int[]> neighbors(int row, int col){
        List<int[]> list = new LinkedList();
        int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] direction : directions) {
            int[] pt = new int[]{row + direction[0], col + direction[1]};
            if (isValid(pt)){
                list.add(pt);
            }
        }
        return list;
    }

    private boolean isValid(int[] point){
        int row = point[0];
        int col = point[1];
        return (row >= 0 && row < board.length && col >= 0 && col < board[0].length);
    }

    public static void main(String[] args) {
        char[][] arr = {{'a'}};
        Q79 test = new Q79();
        System.out.println(test.exist(arr, "a"));
                
    }
}
