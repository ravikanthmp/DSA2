package DSA.leetcode;

import java.util.List;

public class Q784 {

    private String s;
    private List<String> results;

    public List<String> letterCasePermutation(String s) {
        this.s = s;
        backtrack(0, new StringBuilder());
        return results;
    }

    private void backtrack(int idx, StringBuilder soFar){
        if (idx == s.length()){
            results.add(soFar.toString());
            return;
        }
        char currChar = s.charAt(idx);
        if (Character.isDigit(currChar)){
            backtrack(idx + 1, soFar);
        }else{

            char upperCase = Character.toUpperCase(currChar);
            soFar.append(upperCase);
            backtrack(idx + 1, soFar);
            soFar.deleteCharAt(soFar.length() - 1);

            char lowerCase = Character.toLowerCase(currChar);
            soFar.append(lowerCase);
            backtrack(idx + 1, soFar);
            soFar.deleteCharAt(soFar.length() - 1);
        }
    }

}
