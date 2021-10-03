package DSA.leetcode;

public class Q1143 {

    int[][] tab;

    public int longestCommonSubsequence(String text1, String text2) {
        int M = text1.length();
        int N = text2.length();
        tab = new int[M][N];
        tab[M - 1][N - 1] = (text1.charAt(M - 1) == text2.charAt(N - 1)) ? 1 : 0;
        for (int row = M - 1; row >= 0; row--) {
            for (int col = N - 1; col >= 0; col--) {
                int res = 0;
                if (text1.charAt(row) == text2.charAt(col)){
                    res = 1 + val(tab, row + 1, col + 1);
                }else {
                    res = Math.max(val(tab, row, col + 1),
                            val(tab, row + 1, col));
                }
                tab[row][col] = res;
            }
        }

        return tab[0][0];
    }

    private int val(int[][] tab, int row, int col){
        if (row >= 0 && row < tab.length && col >= 0 && col < tab[0].length){
            return tab[row][col];
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        Q1143 test = new Q1143();
        System.out.println(test.longestCommonSubsequence(text1, text2));
    }
}
