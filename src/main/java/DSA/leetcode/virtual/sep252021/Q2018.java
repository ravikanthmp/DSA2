package DSA.leetcode.virtual.sep252021;

public class Q2018 {

    private char[][] board;
    private Boolean[][] memo;
    private boolean[][] visited;
    private String word;

    public boolean placeWordInCrossword(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.memo = new Boolean[board.length][board[0].length];
        this.visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean ans = test(i, j, 0);
                if (ans){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean test(int row, int col, int idx) {
        if (idx == word.length()){
            if (!isValid(row, col)){
                return true;
            }else {
                return (board[row][col] != ' ');
            }
        }else {

            Boolean cached = memo[row][col];
            if (cached == null){
                boolean ans = false;
                if (board[row][col] != ' '){
                    ans = false;
                }else {

                }
            }
            visited[row][col] = false;
            return memo[row][col];
        }
    }

    private boolean isValid(int row, int col){
        return (row >=0 && row < board.length) && (col >= 0 && col < board[0].length);
    }

}
