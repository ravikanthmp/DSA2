package DSA.leetcode.contest.biWeekly62;

import java.util.*;

public class Q5872 {

    public int numOfPairs(String[] nums, String target) {

        // reverse map
        Map<String , List<Integer>> reverseMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            reverseMap.putIfAbsent(nums[i], new ArrayList<>());
            List<Integer> list = reverseMap.get(nums[i]);
            list.add(i);
            reverseMap.put(nums[i], list);
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            String curr = nums[i];
            if (target.startsWith(curr)){
                String remaining = target.substring(curr.length());
                if (reverseMap.containsKey(remaining)){
                    List<Integer> list = reverseMap.get(remaining);
                    for (Integer x : list) {
                        if (x != i){
                            count++;
                        }
                    }
                }
            }
        }
//        Arrays.sort(nums);
//        int i = 0;
//        int j = nums.length - 1;

//        while (i < j){
//            if (!target.startsWith(nums[i])){
//                i++;
//            }else if (!target.endsWith(nums[j])){
//                j--;
//            }else {
//                int lCount = reverseMap.get(nums[i]).size();
//                int rCount = reverseMap.get(nums[j]).size();
//
//                if (nums[i].equals(nums[j])){
//                    count = count + ((lCount - 1) * rCount);
//                }else {
//                    count = count + (lCount * rCount);
//                }
//
//
//                i++;
//                j--;
//                while (i < j && nums[i].equals(nums[i - 1])) {
//                    i++;
//                }
//
//                while (i <j && nums[j].equals(nums[j + 1])){
//                    j--;
//                }
//            }
//        }

        return count;


    }

    public static void main(String[] args) {
        String[] s = {"777", "7", "77", "77"};
        String target = "7777";
        Q5872 test = new Q5872();
        System.out.println(test.numOfPairs(s, target));
    }

}
