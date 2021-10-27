package DSA.leetcode.topInterview.hard;

import java.util.*;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {

        List<Integer> list = new LinkedList<>();
        Comparator<Integer> cmp= Comparator.comparingInt(i -> nums[i]);
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(cmp.reversed());
        for (int i = 0; i < k; i++) {
            maxPQ.add(i);
        }
        list.add(maxPQ.peek());

        for (int i = k; i < nums.length; i++) {
            maxPQ.add(i);
            while (!maxPQ.isEmpty() && maxPQ.peek() < (i - k + 1)){
                maxPQ.remove();
            }
            list.add(maxPQ.peek());
        }

        int[] res = new int[list.size()];
        int i = 0;
        for (Integer x : list) {
            res[i++] = x;
        }
        return res;
    }
}
