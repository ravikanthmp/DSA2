package DSA.leetcode.topInterview.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    List<String> res = new LinkedList<>();

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.isEmpty()){
            return res;
        }
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        test(digits, 0, new StringBuilder(), map);

        return res;
    }

    private void test(String digits, int idx, StringBuilder sofar, Map<Integer, String> map) {
        if (idx == digits.length()){
            res.add(sofar.toString());
        }else {
            char c = digits.charAt(idx);
            int cVal = c - '0';
            String mappings = map.get(cVal);
            for (int i = 0; i < mappings.length(); i++) {
                sofar.append(mappings.charAt(i));
                test(digits, idx + 1, sofar, map);
                sofar.deleteCharAt(sofar.length() - 1);
            }

        }
    }
}
