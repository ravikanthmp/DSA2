package DSA.leetcode;

import java.util.Arrays;

public class Q647 {

    public int countSubstrings(String s) {
        boolean[][] tab = new boolean[s.length() + 1][s.length()];

        // base case
       int total = s.length();
       Arrays.fill( tab[0], true);
       Arrays.fill( tab[1], true);
        for (int i = 0; i < s.length() - 2; i++) {
            tab[2][i] = s.charAt(i) == s.charAt(i + 1);
            if (tab[2][i]){
                total++;
            }
        }


       // for lengths 1.. N
        for (int length = 3; length <= s.length(); length++) {

            for (int startIdx = 0; startIdx < s.length() - length; startIdx++) {

                int endIdx = startIdx + length - 1;

                tab[length][startIdx] =
                        (s.charAt(startIdx) == s.charAt(endIdx) && tab[length - 2][startIdx + 1]);

                if ( tab[length][startIdx]){
                    total++;
                }
            }
        }

        return total;
    }


    public static void main(String[] args) {
        Q647 test = new Q647();
        System.out.println(test.countSubstrings("AAA"));
    }
}
