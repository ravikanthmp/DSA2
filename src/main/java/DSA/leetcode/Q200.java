package DSA.leetcode;

public class Q200 {


    public int numIslands(char[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j]){
                    islands++;
                    dfs(i, j, grid, visited);
                }
            }
        }
        return islands;
    }

    private void dfs(int i, int j, char[][] grid, boolean[][] visited) {
        visited[i][j] = true;

        if (isValid(i - 1, j, grid, visited)) {
          dfs(i - 1, j, grid, visited);
        }

        if (isValid(i + 1, j, grid, visited)) {
            dfs(i + 1, j, grid, visited);

        }

        if (isValid(i, j - 1, grid, visited)) {

            dfs(i, j - 1, grid, visited);
        }

        if (isValid(i, j + 1, grid, visited)) {

            dfs(i, j + 1, grid, visited);
        }
    }

    private boolean isValid(int i, int j,  char[][] grid, boolean[][] visited){
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length
                && grid[i][j] == '1' && !visited[i][j];
    }

}
