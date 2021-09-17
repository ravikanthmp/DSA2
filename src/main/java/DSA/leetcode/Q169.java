package DSA.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q169 {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int currCount = map.getOrDefault(nums[i], 0);
            int nextCount = currCount + 1;
            map.put(nums[i], nextCount);
            if (nextCount > nums.length / 2) {
                return nums[i];
            }
        }

        return nums[0];
    }

}
