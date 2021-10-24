package DSA.leetcode.topInterview.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatedCharacters {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0;
        int maxWindowSize = 0;

        for (int right = 0; right < s.length(); right++) {
            while (window.contains(s.charAt(right))){
                window.remove(s.charAt(left++));
            }
            window.add(s.charAt(right));
            maxWindowSize = Math.max(maxWindowSize, window.size());
        }

        return maxWindowSize;

    }

}
