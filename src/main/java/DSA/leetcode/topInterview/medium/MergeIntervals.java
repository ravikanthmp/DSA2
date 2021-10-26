package DSA.leetcode.topInterview.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        // sort by start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> nonIntersecting = new LinkedList<>();
        nonIntersecting.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {

            int[] curr = intervals[i];

            if (intersects(curr, nonIntersecting.get(nonIntersecting.size() - 1))){
                int[] last = nonIntersecting.remove(nonIntersecting.size() - 1);
                int[] merged = {Math.min(last[0], curr[0]), Math.max(last[1], curr[1])};
                nonIntersecting.add(merged);
            }else {
                nonIntersecting.add(curr);
            }
        }

        return nonIntersecting.toArray(x -> new int[x][]);
    }

    private boolean intersects(int[] a, int[] b){
        int[] sooner = a[0] <= b[0] ? a : b;
        int[] later = (sooner == a) ? b : a;
        return later[0] <= sooner[1];
    }

}
