package DSA.leetcode.topInterview.easy;

import java.util.Arrays;

public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int pos = nums1.length - 1;

        m = m - 1;
        n = n - 1;

        while (m >= 0 || n >= 0){
            if (m < 0){
                nums1[pos--] = nums2[n--];
            }else if (n < 0){
                nums1[pos--] = nums1[m--];
            }else {
                if (nums1[m] >= nums2[n]){
                    nums1[pos--] = nums1[m--];
                }else {
                    nums1[pos--] = nums2[n--];
                }
            }
        }
    }

    public static void main(String[] args) {
        MergeSortedArrays test = new MergeSortedArrays();
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;
        test.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

}
