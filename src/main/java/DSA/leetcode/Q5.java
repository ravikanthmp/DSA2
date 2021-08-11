package DSA.leetcode;

public class Q5 {

    public String longestPalindrome(String s){
        boolean[][] dp = new boolean[s.length() + 1][s.length()];
        int maxSoFar = 1;

        for (int i = 0; i < s.length(); i++) {
            dp[0][i] = true;
            dp[1][i] = true;
        }
        String max = s.substring(0, 1);

        for (int size = 2; size <= s.length() ; size++) {
            for (int i = size - 1; i < s.length(); i++) {
                int l = i - size + 1;
                int r = i;
                boolean ans = false;
                if (s.charAt(l) == s.charAt(r)){
                    ans = dp[size - 2][i - 1];
                    if (ans && size > maxSoFar){
                        maxSoFar = size;
                        max = s.substring(l, r + 1);
                    }
                }
                dp[size][i] = ans;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Q5 lp = new Q5();
        System.out.println(lp.longestPalindrome("ac"));
    }
}
