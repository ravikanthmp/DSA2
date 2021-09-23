package DSA.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q295 {

    static class MedianFinder {

        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {

            if (minHeap.isEmpty() || maxHeap.isEmpty()) {
                if (!minHeap.isEmpty()) {
                    minHeap.add(num);
                } else if (!maxHeap.isEmpty()){
                    maxHeap.add(num);
                }else {
                    minHeap.add(num);
                }
            } else if (num >= maxHeap.peek()) {
                 minHeap.add(num);
            } else {
                maxHeap.add(num);
            }
            rebalance();

        }

        private void rebalance() {
            if (Math.abs(maxHeap.size() - minHeap.size()) > 1) {
                if (maxHeap.size() > minHeap.size()) {
                    minHeap.add(maxHeap.remove());
                } else {
                    maxHeap.add(minHeap.remove());
                }
            }
        }

        public double findMedian() {
            int size = maxHeap.size() + minHeap.size();
            if (size % 2 != 0) {
                // if odd return mid
                if (minHeap.size() > maxHeap.size()) {
                    return minHeap.peek();
                } else {
                    return maxHeap.peek();
                }
            } else {
                // return mean of
                return (minHeap.peek() + maxHeap.peek()) / 2.0;
            }
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-5);
        System.out.println(medianFinder.findMedian());
    }
}
