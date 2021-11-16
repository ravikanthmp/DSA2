package DSA.practise;


import java.util.HashSet;

import java.util.Set;

class Solution {


    private static boolean isValid(char ch){
        return ch >= 'a' && ch <= 'z';
    }
    public static String solution(String word, String cipher) {

        if (cipher== null || cipher.length() != 26){
            return "";
        }
        Set<Character> seen = new HashSet();
        for (int i = 0; i < cipher.length(); i++) {
            if (seen.contains(cipher.charAt(i))){
                return "";
            }else {
                seen.add(cipher.charAt(i));
            }
        }

        // Type your solution here
        if(word == null || word.length() == 0){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!isValid(ch)){
                return "";
            }
            sb.append(cipher.charAt(ch - 'a'));
        }
        return sb.toString();
    }


    public static void main(String[] args) {

       String word = "helloworld";
       String cipher =  "frnlbcqdygmwhuvszkepaiotxj";
        System.out.println(solution(word, cipher));

    }

}