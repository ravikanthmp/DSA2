package DSA.leetcode.topInterview.easy;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        int i = 0;
        int j = s.length() -1 ;

        while (i < j){
            if (!isAlphaNumeric(s.charAt(i))){
                i++;
            }else if (!isAlphaNumeric(s.charAt(j))){
                j--;
            } else if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }else {
                i++;
                j--;
            }
        }

        return true;
    }

    private boolean isAlphaNumeric(char c){
        return Character.isLetterOrDigit(c);
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome(s));
    }
}
