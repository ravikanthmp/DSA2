package DSA.leetcode;


import java.util.Arrays;

public class Q647 {

    public int countSubstrings(String s) {

        if (s == null || s.isEmpty()){
            return 0;
        }else {
            boolean[] prev = new boolean[s.length()];
            boolean[] prevPrev = new boolean[s.length()];

            // size 1
            Arrays.fill(prevPrev, true);
            int count = s.length();

            // size 2
            for (int i = 0; i < s.length() - 1; i++) {
                prev[i] = (s.charAt(i) == s.charAt(i + 1));
                if (prev[i]){
                    count++;
                }
            }

            for (int size = 3; size <= s.length(); size++) {

                boolean[] temp = new boolean[s.length()];

                for (int startIdx = 0; startIdx <= s.length() - size; startIdx++) {

                    temp[startIdx] =
                            ((s.charAt(startIdx) == s.charAt(startIdx + size - 1)) && prevPrev[startIdx + 1]);
                    if (temp[startIdx]){
                        count++;
                    }
                }

                prevPrev = prev;
                prev = temp;
            }

            return count;
        }
    }

    public static void main(String[] args) {
        Q647 test = new Q647();
        System.out.println(test.countSubstrings("AAA"));
    }
}
