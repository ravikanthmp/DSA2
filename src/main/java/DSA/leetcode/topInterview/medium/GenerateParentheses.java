package DSA.leetcode.topInterview.medium;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {

    private List<String> results;
    private int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        this.results = new LinkedList<>();
        gen(new StringBuilder(), 0, 0);
        return results;
    }

    private void gen(StringBuilder soFar, int left, int right) {
        if (left == n && right == n){
            results.add(soFar.toString());
        }else{
            if (left > right){

                // add left brace
                if (left < n){
                    soFar.append('(');
                    gen(soFar, left + 1, right);
                    soFar.deleteCharAt(soFar.length() - 1);
                }


                // Or add right brace
                if (right < n){
                    soFar.append(')');
                    gen(soFar, left, right + 1);
                    soFar.deleteCharAt(soFar.length() - 1);
                }


            }else {

                // add left brace
                if (left < n){
                    soFar.append('(');
                    gen(soFar, left + 1, right);
                    soFar.deleteCharAt(soFar.length() - 1);
                }


            }
        }
    }


    public static void main(String[] args) {
        GenerateParentheses test = new GenerateParentheses();
        for (String w : test.generateParenthesis(3)) {
            System.out.println(w);
        }

    }
}
