package DSA.leetcode;

import java.util.*;

public class Q56 {
    public int[][] merge(int[][] intervals) {
        // 1. Init PQ
        Interval[] arr = new Interval[intervals.length];
        int i = 0;
        for (int[] interval : intervals) {
            arr[i++] = new Interval(interval[0], interval[1]);
        }
        Arrays.sort(arr, Comparator.comparingInt(interval -> interval.start));

        Stack<Interval> stack = new Stack<>();
        stack.push(arr[0]);

        for (int j = 1; j < arr.length; j++) {
            if (stack.peek().intersects(arr[j])){
                stack.push(stack.pop().merge(arr[j]));
            }else {
                stack.push(arr[j]);
            }
        }
        int[][] res = new int[stack.size()][];
        i = 0;
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
            return later.start <= sooner.end;
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
