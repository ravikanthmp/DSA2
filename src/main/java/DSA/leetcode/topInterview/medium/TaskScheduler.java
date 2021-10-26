package DSA.leetcode.topInterview.medium;

import java.util.*;

public class TaskScheduler {


    class CharHolder{
        char ch;
        int count;

        public CharHolder(char x, Integer count) {
            this.ch = x;
            this.count = count;
        }

        public int getCount(){
            return count;
        }

        public void decrCount(){
            count--;
        }
    }

    public int leastInterval(char[] tasks, int n) {

        List<Character> taskOrder = new LinkedList<>();
        int time = 0;

        // freq map
        int taskCount = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char task : tasks) {
            taskCount++;
            freqMap.put(task, freqMap.getOrDefault(task, 0)  + 1);
        }

        Comparator<CharHolder> charHolderComparator = Comparator.comparingInt(CharHolder::getCount);
        PriorityQueue<CharHolder> maxPQ = new PriorityQueue<>(charHolderComparator.reversed());

        freqMap.forEach((key, value) -> maxPQ.add(new CharHolder(key, value)));


        while (taskCount > 0){

            System.out.println(taskCount);
            List<CharHolder> toBeAdded = new LinkedList<>();

            for (int i = 0; i <= n; i++) {

                if (!maxPQ.isEmpty()){
                    CharHolder max = maxPQ.remove();
                    taskOrder.add(max.ch);
                    time++;
                    max.decrCount();
                    if (max.getCount() != 0){
                        toBeAdded.add(max);
                    }
                    taskCount--;
                }else if (!toBeAdded.isEmpty()){
                    taskOrder.add('I');
                    time++;
                }else {
                    break;
                }
            }


            if (!toBeAdded.isEmpty()){
                maxPQ.addAll(toBeAdded);
            }
            toBeAdded = new LinkedList<>();
        }


        System.out.println(taskOrder);
        return time;

    }


    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler();
        char[] tasks = new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'};
        int n = 3;
        int leastInterval = taskScheduler.leastInterval(tasks, n);
        System.out.println(leastInterval);
    }
}
