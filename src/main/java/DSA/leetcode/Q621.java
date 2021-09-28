package DSA.leetcode;

import java.util.Arrays;

public class Q621 {

    public int leastInterval(char[] tasks, int n) {
        int[] freqMap = new int[26];
        // init freq
        for (char task : tasks) {
            int idx = task - 'A';
            freqMap[idx]++;
        };

        int totalTime = 0;

        while (calcRemaining(freqMap)){
            int minIdx = findMinTasksRemaining(freqMap);
            int minTasksQty = freqMap[minIdx];


            int remTypes = remTypes(freqMap);

            if (remTypes == 1){
                totalTime += (minTasksQty + (minTasksQty - 1)*n);
            }else {
                int timePerRound = remTypes;
                int timeToDo = timePerRound* (minTasksQty) + ((minTasksQty - 1) * (n >= remTypes ? n - remTypes + 1: 0));
                totalTime += timeToDo;
            }


            decrBy(freqMap, minTasksQty);

        }
        return totalTime;
    }


    private void decrBy(int[] freq, int k){
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0){
                freq[i] -= k;
            }
        }
    }
    private int remTypes(int[] freqMap){
        return (int) Arrays.stream(freqMap).filter(x -> x > 0).count();
    }

    private int findMinTasksRemaining(int[] freqMap) {
        int minSoFar = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < freqMap.length; i++) {
            if (freqMap[i] > 0){
                if (freqMap[i] < minSoFar){
                    minSoFar = freqMap[i];
                    minIdx = i;
                }
            }
        }
        return minIdx;
    }

    private boolean calcRemaining(int[] freqMap){
        return Arrays.stream(freqMap).anyMatch(x -> x > 0);
    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        int n = 2;
        Q621 test = new Q621();
        System.out.println(test.leastInterval(tasks, n));
    }

}
