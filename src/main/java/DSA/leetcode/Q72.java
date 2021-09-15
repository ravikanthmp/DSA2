package DSA.leetcode;

public class Q72 {

    Integer[][] dp ;

    public int minDistance(String word1, String word2) {
        dp = new Integer[word1.length() + 1][word2.length() + 1];
        for (int row = 0; row < word1.length(); row++) {
            for (int col = 0; col < word2.length(); col++) {
                dp[row][col] = Integer.MAX_VALUE;
            }
        }
        return minDistance(word1, word2, 0, 0);
    }

    private int minDistance(String word1, String word2, int idx1, int idx2){
        if (idx1 == word1.length() && idx2 == word2.length()){
            return 0;
        }else if (idx1 == word1.length()){
            return word2.length() - idx2;
        }else if (idx2 == word2.length()){
            return word1.length() - idx1;
        }else {

            int saved = dp[idx1][idx2];
            if (saved == Integer.MAX_VALUE){
                int ans;

                if (word1.charAt(idx1) == word2.charAt(idx2)){
                    ans = minDistance(word1, word2, idx1 + 1, idx2 + 1);
                }else {
                    ans = Math.min(
                            1 + minDistance(word1, word2, idx1, idx2 + 1),
                            1 + minDistance(word1, word2, idx1 + 1, idx2)
                    );

                    ans = Math.min(ans,
                            1 + minDistance(word1, word2, idx1 + 1, idx2 + 1)
                    );
                }

                dp[idx1][idx2] = ans;

            }

            return dp[idx1][idx2];

        }

    }

    public static void main(String[] args) {
        Q72 test = new Q72();
        System.out.println(test.minDistance("", ""));
    }
}
