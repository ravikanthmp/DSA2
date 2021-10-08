package DSA.leetcode;

import java.util.*;

public class Q435 {

    public int eraseOverlapIntervals(int[][] intervals) {

        // sort by finishing times
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Collections.addAll(pq, intervals);

        LinkedList<int[]> list = new LinkedList<>();

        while (!pq.isEmpty()){
            int[] first = pq.remove();
            if (list.isEmpty() || !intersects(list.getLast(), first)){
                list.add(first);
            }
        }

        return intervals.length - list.size();

    }

    private boolean intersects(int[] a, int[] b){
        return b[0] < a[1];
    }

    public static void main(String[] args) {
        Q435 test = new Q435();
        int[][] intervals = {{1, 100}, {11, 22},{1, 11}, {2, 12}};
        System.out.println(test.eraseOverlapIntervals(intervals));
    }
}
