package DSA.leetcode;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

public class Q128 {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        TreeSet<Integer> treeSet = new TreeSet<>();
        Arrays.stream(nums).forEach(treeSet::add);

        Integer last = null;
        int maxSoFar = 0;
        int currLength = 0;
        while (!treeSet.isEmpty()){
            Integer curr = treeSet.first();
            treeSet.remove(curr);

            if (last != null){

                if (last == curr - 1){
                    currLength = currLength + 1;
                }else {
                    currLength = 0;
                }

                maxSoFar = Math.max(maxSoFar, currLength);

                last = curr;
            }else {
                currLength = 1;
                last = curr;
            }

        }

        return maxSoFar;

    }

    public static void main(String[] args) {
        int[] arr = {100,4,200,1,3,2};
        Q128 test = new Q128();
        System.out.println(test.longestConsecutive(arr));
    }

}
