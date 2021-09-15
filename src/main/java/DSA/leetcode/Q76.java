package DSA.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q76 {

    class Window{
        int left;
        int right;

        public Window(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> require = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (!require.containsKey(c)) {
                require.put(c, 0);
            }
            require.put(c, require.get(c) + 1);
        }
        int remaining = t.length();
        int left = 0;
        int minWindowSize = Integer.MAX_VALUE;
        Window window = null;
        for (int i = 0; i < s.length(); i++) {
            char right = s.charAt(i);

            // housekeeping
            if (require.containsKey(right)){
                Integer required = require.get(right);
                if (required > 0){
                    remaining--;
                }
                require.put(right, required - 1);
            }


            // shrink window
            if (remaining == 0){

                while (left <= i){

                    if (!require.containsKey(s.charAt(left))){
                        left++;

                    } else if (require.get(s.charAt(left)) < 0){
                        require.put(s.charAt(left), require.get(s.charAt(left)) + 1);
                        left++;
                    }else {
                        break;
                    }

                }

                if ((i - left + 1) < minWindowSize){
                    minWindowSize = (i - left + 1);
                    window = new Window(left, i);
                }
            }


        }
        return window == null ? "" : s.substring(window.left, window.right + 1);
    }


    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        Q76 test = new Q76();
        System.out.println(test.minWindow(s, t));
    }
}
