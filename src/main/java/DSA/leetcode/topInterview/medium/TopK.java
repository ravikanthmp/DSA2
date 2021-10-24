package DSA.leetcode.topInterview.medium;

import java.util.*;

public class TopK {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }


        Comparator<Object> cmp = Comparator.comparingInt(map::get);
        PriorityQueue<Integer> minPQ = new PriorityQueue<>(cmp);
        for (int num : map.keySet()) {
            if (minPQ.size() == k){

                if (cmp.compare(minPQ.peek(), num) < 0){
                    minPQ.remove();
                    minPQ.add(num);
                }
            }else {
                minPQ.add(num);
            }

        }

        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = minPQ.remove();
        }
        return res;
    }

    public static void main(String[] args) {
        TopK test = new TopK();
        int[] arr = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(test.topKFrequent(arr, k)));
    }
}
