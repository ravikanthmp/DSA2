package DSA.leetcode.topInterview.hard;

import java.util.*;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] nge = nextGreaterElement(nums);

        System.out.println(Arrays.toString(nge));
        int[] slidingWindow = new int[nums.length - k + 1];


        int j = 0;
        for (int i = 0; i < slidingWindow.length; i++) {
            if (nge[i] > i + k - 1){
                slidingWindow[i] = nums[i];
            }else {
                j = Math.max(j, i);
                int ans = j;
                while (j <= (i + k - 1)){
                    ans = j;
                    j = nge[j];
                }
                slidingWindow[i] = nums[ans];
                j = ans;
            }
        }

        return slidingWindow;
    }

    private int[] nextGreaterElement(int[] nums){
        int[] nge = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                nge[stack.pop()] = i;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            nge[stack.pop()] = nums.length;
        }

        return nge;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum test = new SlidingWindowMaximum();
        int[] arr = {7,4,1};
        System.out.println(Arrays.toString(test.maxSlidingWindow(arr, 2)));
    }
}
