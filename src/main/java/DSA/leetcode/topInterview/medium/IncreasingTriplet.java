package DSA.leetcode.topInterview.medium;


import java.util.Stack;

public class IncreasingTriplet {


    public boolean increasingTriplet(int[] nums) {
        int[] nge = nextGreaterElement(nums);
        int[] pse = previousSmallerElement(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nge[i] != -1 && pse[i] != -1){
                return true;
            }
        }
        return false;
    }

    private int[] previousSmallerElement(int[] nums) {
        int[] pse = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                pse[stack.pop()] = i;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            pse[stack.pop()] = -1;
        }
        return pse;
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
