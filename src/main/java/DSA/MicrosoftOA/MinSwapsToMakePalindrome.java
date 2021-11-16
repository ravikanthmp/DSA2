package DSA.MicrosoftOA;

import java.util.HashMap;
import java.util.Map;

public class MinSwapsToMakePalindrome {

    public int minSwaps(String s){
        if (s == null || s.isEmpty()){
            return 0;
        }else {
            return minSwaps(s.toCharArray(), 0);
        }
    }

    private int minSwaps(char[] chars, int idx) {
        if (idx == chars.length - 1){
            return Integer.MAX_VALUE;
        }else {
            int ans = Integer.MAX_VALUE;
            if (isPalindrome(chars)){
                return 0;
            }else {
                int x = minSwaps(chars, idx + 1);
                if (x != Integer.MAX_VALUE){
                    ans = x;
                }
                if (chars[idx] != chars[idx + 1]){
                    swap(chars, idx, idx + 1);
                    int y = minSwaps(chars, idx + 1);
                    if (y != Integer.MAX_VALUE){
                        ans = Math.min(1 + y, ans);
                    }
                    swap(chars, idx, idx + 1);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String s = "mamad";
        MinSwapsToMakePalindrome minSwapsToMakePalindrome = new MinSwapsToMakePalindrome();

        System.out.println(minSwapsToMakePalindrome.minSwaps(s));
    }

    private void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private boolean isPalindrome(char[] chars){
        int left = 0;
        int right = chars.length - 1;
        while (left < right){
            if (chars[left] != chars[right]){
                return false;
            }else {
                left++;
                right--;
            }
        }
        return true;
    }
}
