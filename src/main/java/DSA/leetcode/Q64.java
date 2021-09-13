package DSA.leetcode;

public class Q64 {
    public int minPathSum(int[][] grid) {

        int[] tab = new int[grid[0].length];
        int prev = 0;
        for (int i = 0; i < tab.length; i++) {
            tab[i] = grid[0][i] + prev;
            prev = tab[i];
        }

        for (int i = 1; i < grid.length; i++) {

            for (int col = 0; col < tab.length; col++) {

                if (col == 0){
                    tab[col] = tab[col] + grid[i][col];
                }else {
                    tab[col] = grid[i][col] +  Math.min(
                            tab[col], tab[col - 1]
                    );
                }
            }

        }
        return tab[tab.length - 1];
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}};
        Q64 test = new Q64();
        System.out.println(test.minPathSum(arr));
    }

}
