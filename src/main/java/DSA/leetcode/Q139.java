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
        return test(0);
    }

    private boolean test(int idx) {
        if (idx == s.length()){
            return true;
        }else {

            if (memo[idx] == null){
                boolean ans = false;
                String suffix = s.substring(idx);
                for (String word : wordDict) {
                    if (suffix.startsWith(word)){
                        ans = test(idx + word.length());
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
        String[] arr = {"leet", "code"};
        System.out.println(test.wordBreak("leetcode", Arrays.asList(arr)));
    }

}
