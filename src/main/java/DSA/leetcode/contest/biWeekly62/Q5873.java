package DSA.leetcode.contest.biWeekly62;

import java.util.HashMap;
import java.util.Map;

public class Q5873 {

    private Map<Integer, Map<Integer, Integer>> memo;
    private String answerKey;
    private int k;

    public int maxConsecutiveAnswers(String answerKey, int k) {
        this.answerKey = answerKey;
        this.k = k;
        memo = new HashMap<>();
        return test(answerKey.toCharArray(), 0, k);
    }

    private int test(char[] str, int idx, int k) {
        if (idx == str.length || k == 0){
            return count(str);
        } else {
            if (idx == 7){
                System.out.println(",,,");
            }
//            if (memo.containsKey(idx)){
//                Map<Integer, Integer> map = memo.get(idx);
//                if (map.containsKey(k)){
//                    return map.get(k);
//                }
//            }

            char currChar = answerKey.charAt(idx);
            int ans = 0;
            if (currChar == 'T'){
                str[idx] = 'F';
                ans = test(str, idx + 1, k -1 );
                str[idx] = 'T';
                ans = Math.max(ans, test(str, idx + 1, k ));
            }else {
                str[idx] = 'T';
                ans = test(str, idx + 1, k -1 );
                str[idx] = 'F';
                ans = Math.max(ans, test(str, idx + 1, k ));
            }

//            memo.putIfAbsent(idx, new HashMap<>());
//            Map<Integer, Integer> map = memo.get(idx);
//            map.putIfAbsent(k, ans);


            return ans;
        }
    }

    private int count(char[] str) {
        int currMax = 1;
        int count = 1;
        int i = 1;
        while (i < str.length){

            if (str[i] == str[i - 1]){
                count++;
            }else {
                count = 1;
            }

            currMax = Math.max(currMax, count);
            i++;
        }
        return currMax;
    }


    public static void main(String[] args) {
        String answerKey = "TTTTTFTFFT";
        int k = 2;
        Q5873 test = new Q5873();
        System.out.println(test.maxConsecutiveAnswers(answerKey, k));
    }
}
