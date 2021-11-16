package DSA.leetcode.topInterview.hard;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {

        int[] expected = new int[52];
        for (int i = 0; i < t.length(); i++) {
            expected[mapToInt(t.charAt(i))]++;
        }


        int[] actual = new int[52];
        int left = 0;

        int minSoFar = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            actual[mapToInt(ch)]++;

            if (contained(expected, actual)) {
                do {
                    if ( (i - left + 1) < minSoFar){
                        minSoFar = (i - left + 1);
                        l = left;
                        r = i;
                    }
                    char chLeft = s.charAt(left);
                    actual[mapToInt(chLeft)]--;
                    left++;
                } while (contained(expected, actual));
            }
        }

        return minSoFar == Integer.MAX_VALUE ? "" :  s.substring(l, r + 1);
    }

    private int mapToInt(char ch){
        if (ch >= 'a' && ch <= 'z'){
            return ch - 'a';
        }else if (ch >= 'A' && ch <= 'Z'){
            return ch - 'A' + 26;
        }
        return -1;
    }

    private boolean contained(int[] expected, int[] actual){
        for (int i = 0; i < expected.length; i++) {
            if (expected[i] > 0){
                if (actual[i] < expected[i]){
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring test = new MinimumWindowSubstring();
        String s = "a", t = "aa";
        System.out.println(test.minWindow(s, t));
    }
}
