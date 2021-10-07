package DSA.leetcode;

import java.util.*;

public class Q269 {

    public String alienOrder(String[] words) {

        int maxLength = Arrays.stream(words)
                .mapToInt(String::length)
                .max().orElse(0);
        if (maxLength == 0) {
            return "";
        } else {
            int[] charPos = new int[26];
            Set<Character> added = new HashSet<>();

            int pos = 0;
            for (int i = 0; i < maxLength; i++) {

                Character prev = null;

                for (String word : words) {
                    if (i >= word.length()){
                        continue;
                    }

                    char ch = word.charAt(i);
                    if (!added.contains(ch)){

                        charPos[ch - 'a'] = pos++;
                        added.add(ch);
                    }else if (prev != null && added.contains(prev)){
                        int currCharPos = charPos[ch - 'a'];
                        int prevCharPos = charPos[prev - 'a'];
                        if (currCharPos > prevCharPos){
                            return "";
                        }
                    }

                    prev = ch;
                }
            }


            StringBuilder sb = new StringBuilder();

            TreeMap<Integer, Character> map = new TreeMap<>();
            for (int i = 0; i < pos; i++) {
                map.put(i, (char) (i - 'a'));
            }
            for (Character value : map.values()) {
                sb.append(value);
            }
            return sb.toString();

        }


    }

    public static void main(String[] args) {
        String[] strings = {"wrt","wrf","er","ett","rftt"};
        Q269 test = new Q269();
        System.out.println(test.alienOrder(strings));
    }

}
