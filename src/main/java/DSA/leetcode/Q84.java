package DSA.leetcode;
import java.util.Stack;

public class Q84 {

    public int largestRectangleArea(int[] heights) {
        int[] nextSmallerElement = nse(heights);
        int[] previousSmallerElement = pse(heights);

        int maxSoFar = 0;
        int currArea = 0;
        for (int i = 0; i < heights.length; i++) {
            currArea = heights[i];
            int j = nextSmallerElement[i];
            int k = previousSmallerElement[i];

            if (j != i + 1){
                currArea += (j - i - 1)*heights[i];
            }

            if (k != i - 1){
                currArea += (i - k - 1)*heights[i];
            }

            maxSoFar = Math.max(maxSoFar, currArea);
        }

        return maxSoFar;
    }

    private int[] nse(int[] heights) {
        int[] nse = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                nse[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            nse[stack.pop()] = heights.length;
        }
        return nse;
    }

    private int[] pse(int[] heights) {
        int[] nse = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                nse[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            nse[stack.pop()] = -1;
        }
        return nse;
    }

    public static void main(String[] args) {
        int[] arr ={2, 1, 5, 6, 2, 3};
        Q84 test = new Q84();
        System.out.println(test.largestRectangleArea(arr));
    }
}
