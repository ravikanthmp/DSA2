package DSA.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q91 {

    private String s;
    private Map<Integer, Integer> memo;
    private Map<Integer, Character> map;

    public int numDecodings(String s) {
        this.s = s;
        this.memo = new HashMap<>();

        // pos
        map = new HashMap<>();
        for (char ch = 'A'; ch <= 'Z'; ch++){
            map.put((ch - 'A') + 1, ch);
        }

        return test(0);
    }

    private int test(int idx) {
        if (idx == s.length()){
            return 0;
        }else {

            if (!memo.containsKey(idx)){

                int ans = 0;

                // this one
                Integer cAsInt = Integer.parseInt(s, idx, idx + 1, 10);
                if (map.containsKey(cAsInt)){
                   ans = 1 + test(idx + 1);
                }


                // 2 digits ?
                if (idx < s.length() - 1){
                    cAsInt = Integer.parseInt(s, idx, idx + 2, 10);
                    if (map.containsKey(cAsInt)){
                        ans = ans + 1 + test(idx + 2);
                    }
                }

                memo.put(idx, ans);
            }

            return memo.get(idx);

        }
    }

    public static void main(String[] args) {
        String s = "12";
        Q91 test = new Q91();
        System.out.println(test.numDecodings(s));
    }
}
