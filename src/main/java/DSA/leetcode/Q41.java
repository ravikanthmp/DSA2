package DSA.leetcode;

import java.util.Set;
import java.util.TreeSet;

public class Q41 {

    public int firstMissingPositive(int[] nums) {
        TreeSet<Integer> seen = new TreeSet<>();
        for (int a : nums) {
            if (a > 0){
                seen.add(a);
            }
        }
        int prev = 0;

        while (!seen.isEmpty()){
            int min = seen.first();
            if (min != prev + 1){
                return prev + 1;
            }
            prev = min;
            seen.remove(min);
        }
        return nums.length;
    }

}
