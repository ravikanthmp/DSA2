package DSA.leetcode.topInterview.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindCommonCharacters {

    public List<String> commonChars(String[] words) {
        List<String> ans = new LinkedList<>();

        boolean[] common = new boolean[26];
        Arrays.fill(common, true);

        boolean[] contains = new boolean[26];
        for (String word : words) {
            Arrays.fill(contains, false);
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                contains[ch - 'a'] = true;
            }

            for (int i = 0; i < common.length; i++) {
                common[i] = common[i] & contains[i];
            }
        }

        for (int i = 0; i < common.length; i++) {
            if (common[i]){

                ans.add("" + (char)('a' + i));
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        FindCommonCharacters test = new FindCommonCharacters();
        String[] words = {"bella","label","roller"};
        System.out.println(test.commonChars(words));
    }
}
