package DSA.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Q435 {

    public int eraseOverlapIntervals(int[][] intervals) {

        int[] tab = new int[intervals.length];
        tab[intervals.length - 1] = 1;

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        for (int i = intervals.length - 2; i >= 0; i--) {

            int[] curr = intervals[i];

            int ans = 1;
            int j;
            for ( j = i + 1; j < intervals.length; j++) {
                int[] interval = intervals[j];
                if (interval[0] >= curr[1]){
                    break;
                }else {
                    ans = Math.max(ans, tab[j]);
                }
            }
            if (j != intervals.length){
                tab[i] = Math.max(1 + tab[j], ans);
            }else {
                tab[i] = ans;
            }
        }

        return intervals.length - tab[0];


    }

    public static void main(String[] args) {
        Q435 test = new Q435();
        int[][] intervals = {{1, 100}, {11, 22},{1, 11}, {2, 12}};
        System.out.println(test.eraseOverlapIntervals(intervals));
    }
}
