package DSA.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q170 {

    class TwoSum {

        Map<Integer, List<Integer>> nums;
        int total;

        public TwoSum() {
            nums = new HashMap<>();
        }

        public void add(int number) {
            nums.putIfAbsent(number, new LinkedList<>());
            nums.get(number).add(0, total++);
        }

        public boolean find(int value) {
            boolean found = false;
            for (Integer num : nums.keySet()) {
                int x = value - num;
                if (x == num){
                    found = nums.get(num).size() > 1;
                }else {
                    found = nums.containsKey(x);
                }
                if (found){
                    return true;
                }
            }
            return found;
        }
    }

}
