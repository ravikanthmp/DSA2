package DSA.leetcode;

public class Q76 {

    public String minWindow(String s, String t) {

        int[] requiredFrequency = new int[52];

        for (int i = 0; i < t.length(); i++) {
            int idx = mapToInt(t.charAt(i));
            requiredFrequency[idx]++;
        }


        int[] currentFrequency = new int[52];
        int left = 0;
        int minWindowSoFar = Integer.MAX_VALUE;
        String minSubstring = null;

        for (int right = 0; right < s.length(); right++) {
            char currChar = s.charAt(right);
            int idx = mapToInt(currChar);
            currentFrequency[idx]++;

            while (isValidWindow(requiredFrequency, currentFrequency)){

                int windowSize = right - left + 1;
                if (windowSize < minWindowSoFar){
                    minWindowSoFar = windowSize;
                    minSubstring = s.substring(left, right + 1);
                }

                char leftChar = s.charAt(left);
                int leftIdx = mapToInt(leftChar);
                currentFrequency[leftIdx]--;
                left++;

            }
        }

        return minSubstring != null ? minSubstring : "";
    }

    private boolean isValidWindow(int[] requiredFrequency, int[] currentFrequency){
        for (int i = 0; i < requiredFrequency.length; i++) {
            if (requiredFrequency[i] > 0){
                if (currentFrequency[i] < requiredFrequency[i]){
                    return false;
                }
            }
        }
        return true;
    }

    private int mapToInt(char ch){
        if (ch >= 'a' && ch <= 'z'){
            return ch - 'a';
        }else if (ch >= 'A' && ch <= 'Z'){
            return ch - 'A' + 26;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "ab";
        String t = "A";
        Q76 test = new Q76();
        System.out.println(test.minWindow(s, t));
    }
}
