package DSA.leetcode;


import java.util.Arrays;

public class Q647 {

    public int countSubstrings(String s) {

        if (s == null || s.isEmpty()){
            return 0;
        }else {

            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                count += check(i, i, s) + check(i, i  + 1, s);
            }
            return count;
        }
    }

    private int check(int i, int j, String s) {
        int count = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            count++;
            i--;
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        Q647 test = new Q647();
        System.out.println(test.countSubstrings("AAA"));
    }
}
