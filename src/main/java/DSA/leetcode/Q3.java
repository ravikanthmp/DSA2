package DSA.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q3 {
    public int lengthOfLongestSubstring(String s) {

        int maxSoFar = 0;
        Set<Character> windowChars = new HashSet<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char r = s.charAt(right);
            while (windowChars.contains(r)){
               windowChars.remove(s.charAt(left++));
            }
            windowChars.add(r);
            maxSoFar = Math.max(maxSoFar, windowChars.size());
        }
        return maxSoFar;
    }
}
