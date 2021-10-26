package DSA.leetcode.topInterview.medium;

public class LongestPalindromicSubstring {

    class Range{
        int l;
        int r;

        public Range(int l, int r) {
            this.l = l;
            this.r = r;
        }

        public int length(){
            return (r - l + 1);
        }

    }

    public String longestPalindrome(String s) {

        if (s == null || s.isEmpty()){
            return "";
        }

        int maxSoFar = 0;
        String maxSubString = "";

        for (int mid = 0; mid < s.length(); mid++) {

            int len = 0;
            int x = 0;
            while (  ((mid - x) >= 0 ) && (mid + x) < s.length() &&
                    s.charAt(mid - x) == s.charAt(mid + x)){
                len = (mid + x) - (mid - x) + 1;

                if(len > maxSoFar){
                    maxSoFar = len;
                    maxSubString = s.substring(mid - x, mid + x + 1);
                }
                x++;
            }
        }


        for (int mid = 0; mid < s.length() - 1; mid++) {

            int len = 0;
            int x = 0;
            while (  ((mid - x) >= 0 ) && (mid + 1 + x) < s.length() &&
                    s.charAt(mid - x) == s.charAt(mid + 1 + x)){
                len = (mid + 1 + x) - (mid - x) + 1;

                if(len > maxSoFar){
                    maxSoFar = len;
                    maxSubString = s.substring(mid - x, mid + x + 2);
                }

                x++;
            }
        }




        return  maxSubString;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring() ;
        System.out.println(lps.longestPalindrome("babad"));
    }
}
