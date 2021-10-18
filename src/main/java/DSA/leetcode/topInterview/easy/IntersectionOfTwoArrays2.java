package DSA.leetcode.topInterview.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class IntersectionOfTwoArrays2 {

    public int[] intersect(int[] nums1, int[] nums2) {

        int[] count = new int[1001];
        for (int i : nums1) {
            count[i]++;
        }

        List<Integer> list = new LinkedList<>();

        for (int i : nums2) {
            if (count[i] > 0){
                list.add(i);
                count[i]--;
            }
        }

        int[] res = new int[list.size()];
        int i = 0;
        for (Integer x : list) {
            res[i++] = x;
        }
        return res;
    }

    public static void main(String[] args) {
       int[] nums1 = {4, 4,9,5};
       int[] nums2 = {9,4,9,8,4};
       IntersectionOfTwoArrays2 test = new IntersectionOfTwoArrays2();
       System.out.println(Arrays.toString(test.intersect(nums1, nums2)));

    }
}
