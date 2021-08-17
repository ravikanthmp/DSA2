package DSA.leetcode;

import java.util.PriorityQueue;
import java.util.Stack;

public class Q56 {
    public int[][] merge(int[][] intervals) {
        // 1. Init PQ
        PriorityQueue<Interval> minPQ = new PriorityQueue<>();
        for (int[] interval : intervals) {
            minPQ.add(new Interval(interval[0], interval[1]));
        }

        // 2. Squash conflicting intervals
        Stack<Interval> stack = new Stack<>();
        Interval minInterval;
        while (!minPQ.isEmpty()){
            minInterval = minPQ.remove();
            while (!stack.isEmpty() && stack.peek().intersects(minInterval)){
                minInterval = stack.pop().merge(minInterval);
            }
            stack.push(minInterval);
        }
        int[][] res = new int[stack.size()][];
        int i = 0;
        while (!stack.isEmpty()){
            Interval pop = stack.pop();
            res[i++] = new int[]{pop.start, pop.end};
        }
        return res;
    }

    class Interval implements Comparable<Interval>{

        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval o) {
            return Integer.compare(this.end, o.end);
        }

        public boolean intersects(Interval other){
            Interval sooner;
            Interval later;
            sooner = Integer.compare(this.end, other.end) <= 0 ? this : other;
            later = this == sooner ? other : this;
            return sooner.end >= later.start && sooner.end <= later.end;
        }

        public Interval merge(Interval other){
            return new Interval(Math.min(start, other.start), Math.max(end, other.end)) ;
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}};
        Q56 test = new Q56();
        int[][] merge = test.merge(arr);
        for (int[] ints : merge) {
            System.out.println(ints[0] + " : " + ints[1]);
        }
    }
}
