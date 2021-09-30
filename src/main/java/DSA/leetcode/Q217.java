package DSA.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q217 {

    public boolean containsDuplicate(int[] nums) {

        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (seen.contains(nums[i])){
                return true;
            }
            seen.add(nums[i]);
        }
        return false;
    }

}
