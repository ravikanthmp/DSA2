package DSA.leetcode;

import java.util.*;

public class Q424 {

    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxSoFar = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
                map.put(s.charAt(right),
                        map.getOrDefault(s.charAt(right), 0) + 1);

                while (!invariantPasses(map, (right - left + 1), k)){
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                    left++;
                }
                maxSoFar = Math.max(maxSoFar, (right - left + 1));
        }
        return maxSoFar;
    }

    private boolean invariantPasses(Map<Character, Integer> map, int substringSize, int k){

        int max = map.values().stream().max(Comparator.naturalOrder()).orElse(0);
        return (substringSize - max) <= k;
    }

    public static void main(String[] args) {
        Q424 test = new Q424();
        String s = "ABAB";
        int k = 2;
        System.out.println(test.characterReplacement(s, k));
    }

}
