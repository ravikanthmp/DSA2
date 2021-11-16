package DSA.MicrosoftOA;

import java.util.*;

public class MinStepsToMakeEqualHeight {

    class Pair{
        int num;
        int freq;

        public Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }

    /**
      T(N) = O(NlogN)
      S(N) = O(N)

     */
    public int minSteps(int[] heights){

        if (heights == null || heights.length == 0){
            return 0;
        }

        Comparator<Pair> cmp = (a, b) -> Integer.compare(a.num, b.num);
        PriorityQueue<Pair> maxPQ = new PriorityQueue<>(cmp.reversed());
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int height : heights) {
            freqMap.put(height, freqMap.getOrDefault(height, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            maxPQ.add(new Pair(entry.getKey(), entry.getValue()));
        }

        int steps = 0;

        while (maxPQ.size() > 1){
            Pair max = maxPQ.remove();
            Pair secondMax = maxPQ.peek();

            steps += max.freq;

            Pair x = new Pair(secondMax.num, secondMax.freq + max.freq);
            maxPQ.remove();
            maxPQ.add(x);
        }

        return steps;
    }

    public static void main(String[] args) {
        // 5, 2, 1
        int[] heights = {5, 2, 1};
        MinStepsToMakeEqualHeight test = new MinStepsToMakeEqualHeight();
        System.out.println(test.minSteps(heights));
    }
}
