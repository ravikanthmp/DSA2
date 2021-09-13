package DSA.leetcode;

import java.util.*;
import java.util.stream.IntStream;

public class Q45 {

    public int jump(int[] nums) {

        int[] stepsToVisit = new int[nums.length];
        boolean[] visited = new boolean[nums.length];
        stepsToVisit[0] = 0;
        visited[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer first = queue.remove();
                for(int neighbourIndex : neighbour(first, nums)){
                    if (!visited[neighbourIndex]){
                        visited[neighbourIndex] = true;
                        stepsToVisit[neighbourIndex] = stepsToVisit[first] + 1;
                        queue.add(neighbourIndex);
                    }
                }
            }

        }

        return stepsToVisit[nums.length - 1];

    }

    private Iterable<Integer> neighbour(Integer idx, int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = idx + 1; i <= idx + nums[idx] ; i++) {
            if (i >= nums.length){
                break;
            }else {
                list.add(i);
            }
        }

        return list;
    }

}
