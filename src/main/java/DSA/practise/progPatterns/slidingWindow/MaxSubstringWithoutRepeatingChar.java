package DSA.practise.progPatterns.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxSubstringWithoutRepeatingChar {

    private String s;

    public MaxSubstringWithoutRepeatingChar(String s) {
        this.s = s;
    }

    public int maxLength(){
        int l = 0;
        Map<Character, Integer> charsSoFar = new HashMap<>();
        int maxSoFar = Integer.MIN_VALUE;
        int sum = 0;
        for (int r = 0; r < s.length(); r++) {
            if (charsSoFar.containsKey(s.charAt(r))){
                while (s.charAt(l) != s.charAt(r)){
                    charsSoFar.remove(s.charAt(l));
                    l++;
                }
                charsSoFar.remove(s.charAt(l++));
            }
            charsSoFar.put(s.charAt(r), r);
            sum = r - l + 1;
            maxSoFar = Math.max(maxSoFar, sum);

        }
        return maxSoFar;
    }

    public static MaxSubstringWithoutRepeatingChar getInstance(String s) {
        return new MaxSubstringWithoutRepeatingChar(s);
    }
    public static void main(String[] args) {
        MaxSubstringWithoutRepeatingChar m = MaxSubstringWithoutRepeatingChar.getInstance("abba");
        System.out.println(m.maxLength());
    }
}
