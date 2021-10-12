package DSA.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q3 {
    public int lengthOfLongestSubstring(String s) {


        int maxSoFar = 0;
        Set<Character> window = new HashSet<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {

            while (window.contains(s.charAt(right))){
                window.remove(s.charAt(left));
                left++;
            }

            window.add(s.charAt(right));

            maxSoFar = Math.max(maxSoFar, window.size());
        }

        return maxSoFar;
    }
}
