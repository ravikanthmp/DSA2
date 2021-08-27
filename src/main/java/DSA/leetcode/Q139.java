package DSA.leetcode;

import java.util.Arrays;
import java.util.List;

public class Q139 {
    private String s;
    private List<String> wordDict;
    private Boolean[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {

        this.s = s;
        this.wordDict = wordDict;
        this.memo = new Boolean[s.length()];
        Arrays.fill(memo, null);
        return wordBreak(0);
    }


    private boolean wordBreak(int idx){
        if (idx == s.length()){
            return true;
        }else {
            Boolean res = memo[idx];
            if (res == null){

                boolean ans = false;

                for (String word : wordDict){
                    int remainingLetters = s.length() - idx;
                    if (word.length() <= remainingLetters){
                        if (s.substring(idx, idx + word.length()).equals(word)){
                            boolean recurse = wordBreak(idx + word.length());
                            if (recurse){
                                ans = true;
                                break;
                            }
                        }
                    }
                }

                memo[idx] = ans;
                return memo[idx];
            }else {
                return res;
            }
        }
    }


    public static void main(String[] args) {
        Q139 test = new Q139();
        String[] arr = {"a"};
        System.out.println(test.wordBreak("a", Arrays.asList(arr)));
    }

}
