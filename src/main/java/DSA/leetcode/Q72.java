package DSA.leetcode;

public class Q72 {

    private Integer[][] memo;

    public int minDistance(String word1, String word2) {
        memo = new Integer[word1.length()][word2.length()];
        return minDistance(word1, word2, 0, 0);
    }

    private int minDistance(String word1, String word2, int idx1, int idx2){
        if (idx1 == word1.length() && idx2 == word2.length()){
            return 0;
        }if (idx1 == word1.length()){
            return word2.length() - idx2;
        }else if (idx2 == word2.length()){
            return word1.length() - idx1;
        }else {

            // check memo
            if (memo[idx1][idx2] != null){
                return memo[idx1][idx2];
            }
            // replace
            int ans = Integer.MAX_VALUE;
            ans = Math.min(ans,
                    word1.charAt(idx1) == word2.charAt(idx2) ?
                    minDistance(word1, word2, idx1  + 1, idx2 + 1) :
                            minDistance(word1, word2, idx1  + 1, idx2 + 1) + 1);
            ans = Math.min(
                    ans,
                    1 + Math.min(minDistance(word1, word2, idx1 + 1, idx2),
                            minDistance(word1, word2, idx1, idx2 + 1))
            );

            memo[idx1][idx2] = ans;
            return memo[idx1][idx2];
        }
    }

    public static void main(String[] args) {
        Q72 test = new Q72();
        System.out.println(test.minDistance("horse", "ros"));
    }
}
