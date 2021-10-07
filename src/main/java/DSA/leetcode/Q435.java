package DSA.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Q435 {

    class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean intersects(Interval other) {
            Interval sooner = (start <= other.start) ? this : other;
            Interval later = (sooner == this) ? other : this;
            return later.start < sooner.end;
        }

        public Interval merge(Interval other) {
            return new Interval(Math.min(start, other.start), Math.max(end, other.end));
        }
    }

    int[] memo;

    public int eraseOverlapIntervals(int[][] intervals) {

        memo = new int[intervals.length];

        Interval[] intervalsArr = Arrays.stream(intervals)
                .map(x -> new Interval(x[0], x[1]))
                .toArray(Interval[]::new);

        Arrays.sort(intervalsArr, Comparator.comparingInt(interval -> interval.start));

        int nonOverlapping =  maxNonOverLappingIntervals(0, intervalsArr);

        return intervals.length - nonOverlapping;
    }

    private int maxNonOverLappingIntervals(int idx, Interval[] intervalsArr){
        if (idx == intervalsArr.length){
            return 0;
        }else {

            if (memo[idx] == 0) {

                Interval curr = intervalsArr[idx];
                int ans = 1;
                for (int i = idx + 1; i < intervalsArr.length; i++) {
                    Interval other = intervalsArr[i];
                    if (other.intersects(curr)){
                        int x = maxNonOverLappingIntervals(i, intervalsArr);
                        ans = Math.max(ans, x);
                    }else {
                        int x = 1 + maxNonOverLappingIntervals(i, intervalsArr);
                        ans = Math.max(ans, x);
                        break;
                    }
                }

                memo[idx] = ans;
            }

            return memo[idx];
        }
    }

    public static void main(String[] args) {
        Q435 test = new Q435();
        int[][] intervals = {{1, 2}, {2, 3},{3, 4}, {1, 3}};
        System.out.println(test.eraseOverlapIntervals(intervals));
    }
}
