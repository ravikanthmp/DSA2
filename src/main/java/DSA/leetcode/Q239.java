package DSA.leetcode;

import java.util.*;

public class Q239 {


    public int[] maxSlidingWindow(int[] nums, int k) {

        Comparator<Integer> cmp = Comparator.comparingInt(x -> nums[x]);

        PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(cmp.reversed());

        // init

        for (int i = 0; i < k; i++) {
            maxPQ.add(i);
        }

        List<Integer> list = new LinkedList<>();
        list.add(maxPQ.peek());

        for (int i = k; i < nums.length; i++) {
            maxPQ.add(i);

            // shrink
            int leftBorder = (i - k + 1);
            while ( maxPQ.peek() < (leftBorder)){
                maxPQ.remove();
            }

            list.add(maxPQ.peek());
        }

        int[] res = new int[list.size()];
        int i = 0;
        for (Integer val : list) {
            res[i++] = nums[val];
        }
        return res;

    }

    public static void main(String[] args) {
        Q239 test = new Q239();
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(test.maxSlidingWindow(arr, k)));
    }

}
