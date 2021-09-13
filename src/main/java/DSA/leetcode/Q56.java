package DSA.leetcode;

import java.util.ArrayList;
import java.util.List;
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
        List<Interval> list = new ArrayList<>();
        while (!minPQ.isEmpty()){
            Interval smallest = minPQ.remove();
            if (list.isEmpty()){
                list.add(smallest);
            }else {
                Interval last = list.remove(list.size() - 1);
                if (last.intersects(smallest)){
                    Interval merged = last.merge(smallest);
                    list.add(merged);
                }else {
                    list.add(last);
                    list.add(smallest);
                }
            }
        }

        int[][] ans = new int[list.size()][];
        int i = 0;
        for (Interval el : list){
            ans[i++] = new int[]{el.start, el.end};
        }
        return ans;
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
            return Integer.compare(this.start, o.start);
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
        int[][] arr = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        Q56 test = new Q56();
        int[][] merge = test.merge(arr);
        for (int[] ints : merge) {
            System.out.println(ints[0] + " : " + ints[1]);
        }
    }
}
