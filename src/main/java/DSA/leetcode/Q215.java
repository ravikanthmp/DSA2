package DSA.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q215 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            pq.add(num);
        }
        int i = 1;
        while (i != k){
            pq.remove();
            i++;
        }
        return pq.peek();
    }

//    private void sort(int[] nums) {
//
//        int shift = 10;
//
//        // init
//        int[] count = new int[(2 * shift) + 1];
//
//        // freq
//        for (int i = 0; i < nums.length; i++) {
//            count[nums[i] + shift]++;
//        }
//
//        // accumulate
//        for (int i = 1; i < count.length; i++) {
//            count[i] += count[i - 1];
//        }
//
//        int[] temp = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            int idx = count[nums[i] + 1];
//            temp[idx] = nums[i];
//            count[nums[i]+1]++;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = temp[i];
//        }
//    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        int k = 2;
        Q215 test = new Q215();
        System.out.println(test.findKthLargest(arr, k));
    }
}
