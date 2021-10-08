package DSA.leetcode;

import java.util.Arrays;

public class Q253 {
    public int minMeetingRooms(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int[] startEvents = new int[intervals.length];
        int[] endEvents = new int[intervals.length];

        int i = 0;
        for (int[] interval : intervals) {
            startEvents[i] = interval[0];
            endEvents[i] = interval[1];
            i++;
        }

        Arrays.sort(startEvents);
        Arrays.sort(endEvents);

        int startIndex = 0;
        int endIndex = 0;
        int maxSoFar = Integer.MIN_VALUE;
        while (endIndex < endEvents.length || startIndex < startEvents.length) {

            if (endIndex == endEvents.length) {
                startIndex++;
            } else if (startIndex == startEvents.length) {
                endIndex++;
            } else if (endEvents[endIndex] <= startEvents[startIndex]) {
                endIndex++;
            } else {
                startIndex++;
            }
            maxSoFar = Math.max(maxSoFar, startIndex - endIndex);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        Q253 test = new Q253();
        int[][] arr = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(test.minMeetingRooms(arr));
    }
}
