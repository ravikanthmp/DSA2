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

        return wordBreak(0);
    }

    private boolean wordBreak(int idx) {
        if (idx == s.length()){
            return true;
        }else {
            Boolean saved = memo[idx];
            if (saved == null){
                //abcde -> 5

                String suffix = s.substring(idx);
                boolean ans = false;
                for (String word : wordDict) {
                    if (word.length() <= suffix.length() && suffix.startsWith(word)){
                        ans = wordBreak(idx + suffix.length());
                        if (ans){
                            break;
                        }
                    }
                }

                memo[idx] = ans;
            }
            return memo[idx];
        }
    }


    public static void main(String[] args) {
        Q139 test = new Q139();
        String[] arr = {"leet1", "code"};
        System.out.println(test.wordBreak("leetcode", Arrays.asList(arr)));
    }

}
