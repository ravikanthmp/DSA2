package DSA.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q424 {

    private String s;
    private int k;
    private Set<Character> charSet;
    private char[] word;

    public int characterReplacement(String s, int k) {

        this.s = s;
        this.k = k;
        this.charSet = new HashSet<>();
        this.word = s.toCharArray();
        for (char c : word) {
            charSet.add(c);
        }

        return solve(0, k);
    }

    private int solve(int idx, int k) {
        if (k == 0 || idx == word.length){
            return count();
        }else {

            int ans = 1;
            ans = solve(idx + 1, k);

            for (Character character : charSet) {

                char x = word[idx];

                word[idx] = character;
                ans = Math.max(ans, solve(idx + 1, k - 1));

                word[idx] = x;
            }
            return ans;
        }
    }

    private int count() {

        if (word == null || word.length == 0){
            return 0;
        }

        int maxSoFar = 1;
        int left = 0;
        int curr = 1;
        for (int right = 1; right < word.length; right++) {

            if (word[left] == word[right]){
                curr++;
            }else {
                curr = 1;
                left = right;
            }
            maxSoFar = Math.max(maxSoFar, curr);
        }

        return maxSoFar;
    }


    public static void main(String[] args) {
        Q424 test = new Q424();
        String s = "ABAB";
        int k = 2;
        System.out.println(test.characterReplacement(s, k));
    }

}
