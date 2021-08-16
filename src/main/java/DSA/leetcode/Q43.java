package DSA.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q43 {

    private int[] nums;
    private boolean[] visited;
    private int[] distTo;

    public int jump(int[] nums) {
        this.visited = new boolean[nums.length];
        visited[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> temp = new LinkedList<>();
        distTo = new int[nums.length];
        distTo[0] = 0;
        queue.add(0);
        while (!queue.isEmpty()) {

            Integer el = queue.remove();

            int farthest = Math.min(nums[el] + el, nums.length - 1);
            for (int i = el + 1; i <= farthest ; i++) {
                if (!visited[i]){
                    visited[i] = true;
                    distTo[i] = distTo[el] + 1;
                    queue.add(i);
                }
            }
        }

        return distTo[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = {0};
        Q43 test = new Q43();
        System.out.println(test.jump(arr));
    }
}
