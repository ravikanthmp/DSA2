package DSA.leetcode.virtual.sep182021;

import java.util.Stack;

public class Q2012 {

    public int sumOfBeauties(int[] nums) {

        int sum = 0;
        int[] pge = pge(nums);
        int[] nse = nse(nums);
        for (int i = 1; i < nums.length - 1; i++) {
            sum += score(nums, i, pge, nse);
        }
        return sum;
    }

    private int score(int[] nums ,int idx, int[] pge, int[] nse){
        if (pge[idx] == -1 && nse[idx] == nums.length){
            return 2;
        }else if ( (nums[idx - 1] < nums[idx]) && (nums[idx] < nums[idx + 1])){
            return 1;
        }else {
            return 0;
        }
    }

    private int[] pge(int[] nums){

        int[] pge = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(nums.length - 1);
        for (int i = nums.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]){
                pge[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            pge[stack.pop()] = -1;
        }
        return pge;
    }

    private int[] nse(int[] nums){

        int[] nse = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]){
                nse[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            nse[stack.pop()] = nums.length;
        }
        return nse;
    }

    public static void main(String[] args) {
        Q2012 test = new Q2012();
        int[] nums = {3,2,1};
        System.out.println(test.sumOfBeauties(nums));
    }
}
