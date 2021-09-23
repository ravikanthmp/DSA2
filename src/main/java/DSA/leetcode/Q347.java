package DSA.leetcode;

import java.util.*;

public class Q347 {

    class Pair{
        int num;
        int freq;

        public Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        /*
        T(N) = O(NlogN) if k ~ N
        S(N) = O(N)
         */

        // store frequency O(N)
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num , 0) + 1);
        }

        // top k O(N)
        Comparator<Pair> cmp = Comparator.comparingInt(x -> x.freq);
        PriorityQueue<Pair> pq = new PriorityQueue<>(cmp);
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (pq.size() == k){
                if (entry.getValue() > pq.peek().freq){
                    pq.remove();
                }else {
                    continue;
                }
            }
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }

        // O(klogN)
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.remove().num;
        }
        return res;

    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int k = 2;
        Q347 test = new Q347();
        System.out.println(Arrays.toString(test.topKFrequent(arr, k)));
    }
}
