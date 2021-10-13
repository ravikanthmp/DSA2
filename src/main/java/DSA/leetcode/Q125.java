package DSA.leetcode;

public class Q125 {

    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            char l = s.charAt(left);
            char r = s.charAt(right);

            if (!isAlphaNumeric(l)){
                left++;
            }else if (!isAlphaNumeric(r)){
                right--;
            }else {
                if (Character.toLowerCase(l) != Character.toLowerCase(r)){
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    private boolean isAlphaNumeric(Character ch){
        return Character.isDigit(ch) || Character.isAlphabetic(ch);
    }
}
