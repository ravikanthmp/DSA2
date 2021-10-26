package DSA.leetcode.topInterview.medium;

class TicTacToe {

    private final int[] player1Rows;
    private final int[] player2Rows;
    private final int[] player1Cols;
    private final int[] player2Cols;
    private int n;
    private int player1Diag;
    private int player2Diag;
    private int player1AntiDiag;
    private int player2AntiDiag;

    char[][] board;

    public TicTacToe(int n) {

        board = new char[n][n];
        this.player1Rows = new int[n];
        this.player2Rows = new int[n];
        this.player1Cols = new int[n];
        this.player2Cols = new int[n];
        this.n = n;
    }

    public int move(int row, int col, int player) {
        board[row][col] = (player == 1) ? 'X' : 'O';

        if (player == 1) {
            player1Rows[row]++;
            player1Cols[col]++;
            if (row == col) {
                player1Diag++;
            }
            if (col == (board[0].length - 1 - row)) {
                player1AntiDiag++;
            }

            if (player1Rows[row] == n || player1Cols[col] == n || player1Diag == n || player1AntiDiag == n){
                return 1;
            }else {
                return 0;
            }
        } else {
            player2Rows[row]++;
            player2Cols[col]++;
            if (row == col) {
                player2Diag++;
            }
            if (col == (board[0].length - 1 - row)) {
                player2AntiDiag++;
            }
            if (player2Rows[row] == n || player2Cols[col] == n || player2Diag == n || player2AntiDiag == n){
                return 1;
            }else {
                return 0;
            }
        }
    }


}
