package DSA.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q253 {

    /**
     * T(N) : O(NlgN)
     * O(N) : O(N)
     */
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        int[][] copyOfIntervals = Arrays.copyOf(intervals, intervals.length);
        Arrays.sort(copyOfIntervals, Comparator.comparingInt(x -> x[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        int maxSoFar = Integer.MIN_VALUE;
        for (int[] interval : copyOfIntervals) {
            if (pq.isEmpty()){
                pq.add(interval);
            }else if (interval[0] >= pq.peek()[1]){
                pq.remove();
                pq.add(interval);
            }else {
                pq.add(interval);
            }
            maxSoFar = Math.max(maxSoFar, pq.size());
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        Q253 test = new Q253();
        int[][] arr = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(test.minMeetingRooms(arr));
    }
}
