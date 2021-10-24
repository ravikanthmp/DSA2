package DSA.leetcode.topInterview.medium;

import java.util.Stack;

public class IncreasingTriplet {

    public boolean increasingTriplet(int[] nums) {
        int[] nge = nextGreaterElement(nums);
        int smallestSoFar = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {

            if ((nge[i] != -1) && (smallestSoFar < nums[i])){
                return true;
            }

            smallestSoFar = Integer.min(smallestSoFar, nums[i]);
        }
        return false;
    }

    private int[] nextGreaterElement(int[] nums) {
        int[] nge = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                nge[stack.pop()] = i;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            nge[stack.pop()] = -1;
        }
        return nge;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,0,4,1,3};
        IncreasingTriplet increasingTriplet = new IncreasingTriplet();
        System.out.println(increasingTriplet.increasingTriplet(arr));
    }
}
