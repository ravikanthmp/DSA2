package DSA.leetcode;


public class Q647 {

    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += palindromeCount(i, s);
        }
        return res;
    }

    private int palindromeCount(int i, String s) {
        return check(i, i, s) + check(i, i + 1, s);
    }

    private int check(int left, int right, String s) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)){
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        Q647 test = new Q647();
        System.out.println(test.countSubstrings("AAA"));
    }
}
