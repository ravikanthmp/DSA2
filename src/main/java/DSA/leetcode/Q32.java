package DSA.leetcode;

import java.util.Arrays;

public class Q32 {

    public int longestValidParentheses(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        boolean[] tab = new boolean[s.length()];
        boolean[] temp ;
        Arrays.fill(tab, true);
        int strSize = 0;
        int maxSoFar = 0;
        for(strSize = 2; strSize <= s.length(); strSize+=2){
            temp = new boolean[s.length()];
            for (int i = strSize - 1; i < s.length(); i++) {
                int endIdx = i;
                int startIdx = i - strSize + 1;
                if ((s.charAt(startIdx) == '(') && (s.charAt(endIdx) == ')')){
                    temp[endIdx] = tab[endIdx - 1];
                    if (temp[endIdx]){
                        maxSoFar = Math.max(maxSoFar, strSize);
                    }
                }
            }
            tab = temp;
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        String s = ")()())";
        Q32 test = new Q32();
        System.out.println(test.longestValidParentheses(s));
    }

}
