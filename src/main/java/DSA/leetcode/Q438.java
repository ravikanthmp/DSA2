package DSA.leetcode;

import java.util.*;

public class Q438 {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();
        int l = 0;
        int ans = 0;

        int[] freqP = new int[26];
        for (int i = 0; i < p.length(); i++) {
           freqP[p.charAt(i) - 'a']++;
        }

        int[] freqS = new int[26];

        for (int i = 0; i < s.length(); i++) {

            if (freqP[s.charAt(i) - 'a'] > 0){
                freqS[s.charAt(i) - 'a']++;
            }


            if (i >= p.length() - 1){
                if (freqP[s.charAt(l) - 'a'] > 0){
                    freqS[s.charAt(l) - 'a']--;
                }

                if (Arrays.equals(freqS, freqP)){
                    list.add(l);
                }

                l++;
            }


        }

        return list;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        Q438 test = new Q438();
        List<Integer> anagrams = test.findAnagrams(s, p);
        System.out.println(anagrams);
    }
}
