package DSA.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q295 {

    static class MedianFinder{
        PriorityQueue<Integer> getMaxFast = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> getMinFast = new PriorityQueue<>();
        public void MedianFinder() {
        }

        public void addNum(int num) {
            getMaxFast.add(num);
            rebalance();
        }

        private void rebalance() {
            int diff = Math.abs(getMaxFast.size() - getMinFast.size());
            if (diff > 1){

                if (getMaxFast.size() > getMinFast.size()){
                    getMinFast.add(getMaxFast.remove());
                }else {
                    getMaxFast.add(getMinFast.remove());
                }
            }
        }

        public double findMedian() {

            if (getMaxFast.size() == getMinFast.size()){
                return (getMaxFast.peek() + getMinFast.peek())/2.0;
            }else if (getMaxFast.size() > getMinFast.size()){
                return getMaxFast.peek();
            }else {
                return getMinFast.peek();
            }
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}
