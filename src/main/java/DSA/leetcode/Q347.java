package DSA.leetcode;

import java.util.*;

public class Q347 {


    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0)  + 1);
        }

        Comparator<Integer> cmp = (i, j) -> Integer.compare(freqMap.get(i), freqMap.get(j));

        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(cmp.reversed());
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            maxPQ.add(entry.getKey());
        }

        int[] el = new int[k];
        for (int i = 0; i < k; i++) {
            el[i] = maxPQ.remove();
        }
        return el;

    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int k = 2;
        Q347 test = new Q347();
        System.out.println(Arrays.toString(test.topKFrequent(arr, k)));
    }
}
