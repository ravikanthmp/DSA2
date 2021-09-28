package DSA.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q763 {

    public List<Integer> partitionLabels(String s) {

        int[] lastIdx = new int[26];;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            lastIdx[s.charAt(i) - 'a'] = Math.max(lastIdx[s.charAt(i) - 'a'], i);
        }

        int startIdx = 0;
        List<Integer> res = new ArrayList<>();

        while (startIdx < s.length()){
            int currRightEnd = lastIdx[s.charAt(startIdx) - 'a'];

            for (int j = startIdx + 1; j <= currRightEnd; j++) {
                currRightEnd = Math.max(currRightEnd, lastIdx[s.charAt(j) - 'a']);
            }

            res.add(currRightEnd - startIdx + 1);
            startIdx = currRightEnd + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        String s ="ababcbacadefegdehijhklij";
        Q763 test = new Q763();
        System.out.println(test.partitionLabels(s));
    }
}
