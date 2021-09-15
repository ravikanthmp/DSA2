package DSA.leetcode;

import java.util.Stack;

public class Q84 {

    public int largestRectangleArea(int[] heights) {
        int maxSoFar = 0;
        int[] nse = nse(heights);
        int[] pse = pse(heights);
        for (int i = 0; i < heights.length; i++) {
            int area = area(heights, i, nse, pse);
            maxSoFar = Math.max(maxSoFar, area);
        }
        return maxSoFar;
    }

    private int area(int[] heights, int i, int[] nse, int[] pse) {
       int right = nse[i] - 1;
       int left = pse[i] + 1;
        int width = (right - left + 1);

        return heights[i] * width;
    }

    private int[] nse(int[] heights) {
        int[] nse = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                nse[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            nse[stack.pop()] = heights.length;
        }
        return nse;
    }

    private int[] pse(int[] heights) {
        int[] pse = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(heights.length - 1);
        for (int i = heights.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                pse[stack.pop()] = i;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            pse[stack.pop()] = -1;
        }

        return pse;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        Q84 test = new Q84();
        System.out.println(test.largestRectangleArea(arr));
    }
}
