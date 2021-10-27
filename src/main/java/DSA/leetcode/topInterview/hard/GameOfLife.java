package DSA.leetcode.topInterview.hard;

public class GameOfLife {

    public void gameOfLife(int[][] board) {

        if (board == null || board.length == 0){
            return;
        }

        int[] prevTemp = null;

        for (int row = 0; row < board.length; row++) {
            int[] temp = gameOfLife(board, row);
            if(prevTemp != null){
                board[row - 1] = prevTemp;
            }
            prevTemp = temp;
        }

        board[board.length - 1] = prevTemp;

    }

    private int[] gameOfLife(int[][] board, int row){

        int[] temp = new int[board[0].length];

        for (int col = 0; col < board[0].length; col++) {


            int count = 0;

            int[] rowDiff = {-1, 0, 1};
            int[] colDiff = {-1, 0, 1};
            for (int i : rowDiff) {
                for (int j : colDiff) {
                    int newRow = row + i;
                    int newCol = col + j;
                    if (newRow == row && newCol == col){
                        continue;
                    }else if (isValid(board, newRow, newCol)){
                        if (board[newRow][newCol] == 1){
                            count++;
                        }
                    }

                }
            }

            if (board[row][col] == 1){
                temp[col] = (count >= 2 && count <= 3) ? 1 : 0;
            }else {
                temp[col] = (count == 3) ? 1 : 0;
            }

        }

        return temp;

    }

    private boolean isValid(int[][] board, int row, int col){
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }

}
