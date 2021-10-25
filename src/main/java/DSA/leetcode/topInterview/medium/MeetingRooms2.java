package DSA.leetcode.topInterview.medium;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms2 {

    abstract class Event{
        public Event(int time) {
            this.time = time;
        }

        int time;
        public int getTime(){
            return time;
        }
    }

    class Start extends Event{

        public Start(int time) {
            super(time);
        }
    }

    class End extends Event{

        public End(int time) {
            super(time);
        }
    }

    public int minMeetingRooms(int[][] intervals) {

        Event[] start = new Start[intervals.length];
        Event[] end = new End[intervals.length];

        int idx = 0;
        for (int[] interval : intervals) {
                start[idx] = new Start(interval[0]);
                end[idx] = new End(interval[1]);
                idx++;
        }

        Arrays.sort(start, Comparator.comparingInt(Event::getTime));
        Arrays.sort(end, Comparator.comparingInt(Event::getTime));

        int i = 0;
        int j = 0;

        int startEvents = 0;
        int endEvents = 0;

        int maxMeetingRooms = 0;
        while (i != start.length){
            if (start[i].getTime() <= end[j].getTime()){
                startEvents++;
                i++;
            }else {
                endEvents++;
                j++;
            }
            maxMeetingRooms = Math.max(maxMeetingRooms, endEvents - startEvents);
        }
        return maxMeetingRooms;

    }

}
