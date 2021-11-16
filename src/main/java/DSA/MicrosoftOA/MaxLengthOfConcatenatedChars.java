package DSA.MicrosoftOA;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxLengthOfConcatenatedChars {

    String[] words;

    public int maxLength(List<String> arr) {
        words = arr.toArray(x -> new String[x]);
        return solve(new HashSet<>(), 0);
    }

    private int solve(Set<Character> sb, int idx) {
        if (idx == words.length) {
            return sb.size();
        } else {
            String word = words[idx];


            int ans = 0;

            if (doesWordContainOnlyUniqueLetters(word) && !containsDup(sb, word)){

                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    sb.add(c);
                }


                int withWord = solve(sb, idx + 1);
                ans = Math.max(ans, withWord);
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    sb.remove(c);
                }
            }
            int withoutWord = solve(sb, idx + 1);
            ans = Math.max(ans, withoutWord);
            return ans;
        }
    }

    private boolean doesWordContainOnlyUniqueLetters(String word){
        Set<Character> seen = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (seen.contains(c)){
                return false;
            }else {
                seen.add(c);
            }
        }
        return true;
    }
    private boolean containsDup(Set<Character> letters, String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (letters.contains(c)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MaxLengthOfConcatenatedChars test = new MaxLengthOfConcatenatedChars();
        System.out.println(test.maxLength(List.of("abc", "ade", "akl")));
    }
}
