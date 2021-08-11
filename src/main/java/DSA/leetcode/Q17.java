package DSA.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q17 {

    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()){
            return result;
        }
        search(digits, 0, result, new StringBuilder(), map);
        return result;
    }

    private void search(String digits, int idx, List<String> result, StringBuilder sb,  Map<Character, String> map) {
        if (idx == digits.length()){
            result.add(sb.toString());
        }else {
            String dictVal = map.get(digits.charAt(idx));
            for(char c : dictVal.toCharArray()){
                sb.append(c);
                search(digits, idx + 1, result, sb, map);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Q17 test = new Q17();
        List<String> stringList = test.letterCombinations("");
        System.out.println(stringList);
    }
}
