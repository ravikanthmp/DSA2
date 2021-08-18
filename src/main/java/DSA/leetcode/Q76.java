package DSA.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q76 {

    class Window{
        int leftIdx;

        public Window(int leftIdx, int rightIdx) {
            this.leftIdx = leftIdx;
            this.rightIdx = rightIdx;
        }

        int rightIdx;
    }
    public String minWindow(String s, String t) {
        int remaining = t.length();
        int minSoFar = Integer.MAX_VALUE;
        Window minWindow = null;
        Map<Character, Integer> require = initRequire(t);
        int l = 0;
        for (int r = 0; r < s.length(); r++) {

            // housekeeping
            if (require.containsKey(s.charAt(r))){
                int numCharsRequired = require.get(s.charAt(r));
                if (numCharsRequired > 0){
                    remaining--;
                }
                require.put(s.charAt(r), numCharsRequired - 1);
            }


            // can shrink ?
            if (remaining <= 0){
                while (l <= r){
                    int lengthOfWindow = r - l + 1;
                    if (lengthOfWindow < minSoFar){
                        minSoFar = lengthOfWindow;
                        minWindow = new Window(l, r);
                    }

                    if (require.containsKey(s.charAt(l))){
                        if (require.get(s.charAt(l)) < 0){
                            require.put(s.charAt(l), require.get(s.charAt(l)) + 1);
                            l++;
                        }else {
                            break;
                        }

                    }else {
                        l++;
                    }


                }
            }
        }

        return minWindow == null ? "" : s.substring(minWindow.leftIdx, minWindow.rightIdx + 1);
    }

    private Map<Character, Integer> initRequire(String t){
        Map<Character, Integer> require = new HashMap<>();
        t.chars().forEach(c -> {
            require.putIfAbsent((char)c, 0);
            require.put((char)c, require.get((char)c) + 1);
        });
        return require;
    }

    public static void main(String[] args) {
        String s = "a";
        String t = "a";
        Q76 test = new Q76();
        System.out.println(test.minWindow(s, t));
    }
}
