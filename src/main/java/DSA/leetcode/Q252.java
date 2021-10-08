package DSA.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Q252 {

    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0){
            return true;
        }
        // sort by start
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prev[1]){
                return false;
            }
        }
        return true;
    }

}
