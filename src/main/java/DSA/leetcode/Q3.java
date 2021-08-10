package DSA.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q3 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxSoFar = 0;
        Set<Character> charsInWindow = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {

            // resize window
            if (charsInWindow.contains(s.charAt(right))){
                while (s.charAt(left) != s.charAt(right)){
                    charsInWindow.remove(s.charAt(left));
                    left++;
                }
                charsInWindow.remove(s.charAt(left));
                left++;
            }

            // Window is "clean" now
            charsInWindow.add(s.charAt(right));
            int size = right - left + 1;
            maxSoFar = Math.max(maxSoFar, size);

        }

        return maxSoFar;
    }
}
