package DSA.leetcode.topInterview.hard;

import java.util.HashMap;
import java.util.Map;

public class SubstringWithKDistinct {


    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
            while (window.size() > k){
                window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                if (window.get(s.charAt(left)) == 0){
                    window.remove(s.charAt(left));
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }


    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        SubstringWithKDistinct test = new SubstringWithKDistinct();
        System.out.println(test.lengthOfLongestSubstringKDistinct(s, k));
    }
}
