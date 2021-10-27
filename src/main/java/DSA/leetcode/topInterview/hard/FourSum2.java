package DSA.leetcode.topInterview.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourSum2 {

    static class Pair{
        int i, j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        static Pair of(int i, int j){
            return new Pair(i, j);
        }
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        int count = 0;

        Map<Integer, List<Pair>> sumMap = new HashMap<>();
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int sum = nums3[i] + nums4[j];
                sumMap.putIfAbsent(sum, new ArrayList<>());
                sumMap.get(sum).add(Pair.of(i, j));
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                if (sumMap.containsKey(-sum)){
                    count = count + sumMap.get(-sum).size();
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        FourSum2 fourSum2 = new FourSum2();
        int[] nums1 = {0}, nums2 = {0}, nums3 = {0}, nums4 = {0};
        System.out.println(fourSum2.fourSumCount(nums1, nums2, nums3, nums4));
    }
}
