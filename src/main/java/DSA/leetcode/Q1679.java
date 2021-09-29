package DSA.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q1679 {

    public int maxOperations(int[] nums, int k) {

        // freq map
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        int total = 0;
        for (Integer x : freqMap.keySet()) {
            int other = k - x;
            if (other < x){
                break;
            }

            if (!freqMap.containsKey(other)){
                continue;
            }
            if (x == other){
                total += freqMap.get(other)/2;
                freqMap.put(x, 0);
            }else {
                int min = Math.min(freqMap.get(x), freqMap.get(other));
                total += min;
                freqMap.put(x, freqMap.get(x) - min);
                freqMap.put(other, freqMap.get(other) - min);
            }
        }

        return total;

    }

}
