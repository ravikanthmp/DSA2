package DSA.leetcode;

import java.util.*;

public class Q57 {

    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        static Interval of(int[] interval) {
            return new Interval(interval[0], interval[1]);
        }

        public boolean intersects(Interval other) {
            Interval sooner = start <= other.start ? this : other;
            Interval later = (sooner == this) ? other : this;
            return later.start <= sooner.end;
        }

        public Interval merge(Interval other) {
           return new Interval(Math.min(start, other.start),
                    Math.max(end, other.end));
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        Interval toBeAdded = Interval.of(newInterval);
        List<Interval> list = new LinkedList<>();

        int i = 0;
        for (i = 0; i < intervals.length; i++) {
            Interval curr = Interval.of(intervals[i]);
            if (curr.start <= toBeAdded.start){
                list.add(curr);
            }else {
                break;
            }
        }


        if (!list.isEmpty() && list.get(list.size() - 1).intersects(toBeAdded)){
            Interval remove = list.remove(list.size() - 1);
            list.add(remove.merge(toBeAdded));
        }else {
            list.add(toBeAdded);
        }

        for (int j = i; j < intervals.length; j++) {
            Interval curr = Interval.of(intervals[j]);
            if (!list.isEmpty() && list.get(list.size() - 1).intersects(curr)){
                Interval remove = list.remove(list.size() - 1);
                list.add(remove.merge(curr));
            }else {
                list.add(curr);
            }
        }

        int[][] arr = new int[list.size()][];
        int k = 0;
        for (Interval interval : list) {
            arr[k++] = new int[]{interval.start, interval.end};
        }
        return arr;
    }


    public static void main(String[] args) {
        Q57 test = new Q57();
        int[][] arr = {{1,3}, {6, 9}};
        int[] newInterval = {2,5};
        System.out.println(Arrays.deepToString(test.insert(arr, newInterval)));
    }
}
