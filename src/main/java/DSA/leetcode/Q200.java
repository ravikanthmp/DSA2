package DSA.leetcode;

public class Q200 {


    public int numIslands(char[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (isValid(i, j, grid, visited)){
                    islands++;
                    dfs(i, j, grid, visited);
                }
            }
        }
        return islands;
    }

    private void dfs(int i, int j, char[][] grid, boolean[][] visited) {
        visited[i][j] = true;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] direction : directions) {
            int i2 = i + direction[0];
            int j2 = j + direction[1];
            if (isValid(i2, j2, grid, visited)){
                dfs(i2, j2, grid, visited);
            }
        }
    }

    private boolean isValid(int i, int j,  char[][] grid, boolean[][] visited){
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length
                && grid[i][j] == '1' && !visited[i][j];
    }

}
