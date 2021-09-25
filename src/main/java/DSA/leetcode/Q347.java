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
        int i;
        do {
            i = quickSelect(nums, frequencyMap);
        }while (i != k);

        // O(klogN)
       return Arrays.copyOf(nums, k);

    }

    private void exch(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int quickSelect(int[] nums, Map<Integer, Integer> frequencyMap){
        int pivot = nums[0];
        int lt = 0;
        int i = 0;
        while (i < nums.length){
            int cmp = Integer.compare(frequencyMap.get(pivot), frequencyMap.get(nums[i]));
            if (cmp <= 0){
                i++; lt++;
            }else {
                exch(nums, lt++, i++);
            }
        }
        return lt;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int k = 2;
        Q347 test = new Q347();
        System.out.println(Arrays.toString(test.topKFrequent(arr, k)));
    }
}
