package DSA.leetcode;

public class Q1143 {

    Integer[][] tab;

    public int longestCommonSubsequence(String text1, String text2) {
        tab = new Integer[text1.length()][text2.length()];
        return lcs(text1, text2, 0, 0);
    }

    private int lcs(String text1, String text2, int idx1, int idx2) {
        if (idx1 == text1.length() || idx2 == text2.length()){
            return 0;
        }else {
            Integer saved = tab[idx1][idx2];
            if (saved == null){
                int ans = 0;
                if (text1.charAt(idx1) == text2.charAt(idx2)){
                    ans = 1 + lcs(text1, text2, idx1 + 1, idx2 + 1);
                }else {
                    ans = Math.max( lcs(text1, text2, idx1, idx2 + 1),
                            lcs(text1, text2, idx1 + 1, idx2));
                }
                tab[idx1][idx2] = ans;
            }
            return tab[idx1][idx2];
        }
    }

    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        Q1143 test = new Q1143();
        System.out.println(test.longestCommonSubsequence(text1, text2));
    }
}
