package DSA.leetcode;

import DSA.practise.stack.Stack;

public class Q1306 {

    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()){
            Integer pop = stack.pop();
            if (pop.equals(0)){
                return true;
            }

            int left = pop - arr[pop];
            int right = pop + arr[pop];

            if (isValid(left, arr) && !visited[left]){
                visited[left] = true;
                stack.push(left);
            }

            if (isValid(right, arr) && !visited[right]){
                visited[right] = true;
                stack.push(right);
            }
        }

        return false;
    }

    private boolean isValid(int i, int[] arr){
        return (i >= 0 && i < arr.length);
    }

    public static void main(String[] args) {
        Q1306 test = new Q1306();
        int[] arr = {4,2,3,0,3,1,2};
        int start = 5;
        System.out.println(test.canReach(arr, start));
    }
}
