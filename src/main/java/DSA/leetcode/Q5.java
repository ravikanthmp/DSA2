package DSA.leetcode;

import java.util.Map;

public class Q5 {

    class Tuple{
        int l, r;
    }
    /**
     * Time : O(N^2)
     * Space : O(N^2)
     */
    public String longestPalindrome(String s) {

        String maxSoFar = "";
        for (int i = 0; i < s.length(); i++) {
            int l1 = palindromeCenteredAt(i, i, s);
            int l2 = palindromeCenteredAt(i, i + 1, s);
            if (l1 >= l2){
                if (l1 > maxSoFar.length()){
                    maxSoFar = s.substring(i - l1/2, i + l1/2 + 1);
                }
            }else {
                if (l2 > maxSoFar.length()){
                    maxSoFar = s.substring(i - l2/2 + 1, i + 1 + l2/2);
                }
            }
        }
        return maxSoFar;
    }

    private int palindromeCenteredAt(int l, int r, String s) {
        if (l < 0 || r == s.length() || s.charAt(l) != s.charAt(r)) {
            return 0;
        }
        int length = 0;
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                length = (r - l + 1);
                l--;
                r++;
            } else {
                break;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        Q5 lp = new Q5();
        System.out.println(lp.longestPalindrome("ac"));
    }
}
