package DSA.leetcode;

import java.util.*;

public class Q56 {
    public int[][] merge(int[][] intervals) {
        // 1. Init PQ
        Comparator<Interval> cmp = Comparator.comparingInt(i -> i.start);

        PriorityQueue<Interval> minPQ = new PriorityQueue<>(cmp);
        for (int[] interval : intervals) {
            minPQ.add(new Interval(interval[0], interval[1]));
        }

        Stack<Interval> stack = new Stack<>();
        stack.push(minPQ.remove());
        while (!minPQ.isEmpty()){
            Interval toBeAdded = minPQ.remove();
            if (stack.peek().intersects(toBeAdded)){
                stack.push(stack.pop().merge(toBeAdded));
            }else {
                stack.add(toBeAdded);
            }
        }

        int[][] res = new int[stack.size()][];
        int i = 0;
        for (Interval interval : stack) {
            res[i++] = new int[]{interval.start, interval.end};
        }
        return res;

    }

    class Interval{
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean intersects(Interval other){
            Interval sooner = start <= other.start ? this : other;
            Interval later = (sooner == this) ? other : this;
            return later.end <= sooner.end;
        }

        public Interval merge(Interval other){
            return new Interval(Math.min(start, other.start),
                                Math.max(end, other.end));
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        Q56 test = new Q56();
        int[][] merge = test.merge(arr);
        for (int[] ints : merge) {
            System.out.println(ints[0] + " : " + ints[1]);
        }
    }
}
