package DSA.MicrosoftOA;

public class LongestSubstringWO {


    public static String longestValidString(String str) {

        int maxSoFar = 0;
        int maxLeft = 0;
        int maxRight = 0;

        if (str == null || str.isEmpty()){
            return "";
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            int sameCount = 1;
            for (int j = i - 1; j >= Math.max(0, i - 2) ; j--) {
                if (str.charAt(j) == c){
                    sameCount++;
                }
            }
            if (sameCount > 2){
                left = i - 1;
                right = i;
            }else {
                right = i;
            }

            if ( (right - left + 1) > maxSoFar){
                maxSoFar = (right - left + 1);
                maxLeft = left;
                maxRight = right;
            }
        }

        return str.substring(maxLeft, maxRight + 1);
    }


    public static void main(String[] args) {
        String a = "aabbaabbaabbaaa";

        System.out.println(longestValidString(a));;
    }
}
