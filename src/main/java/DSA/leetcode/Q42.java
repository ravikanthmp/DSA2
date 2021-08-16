package DSA.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Q42 {

    private int[] height;

    public int trap(int[] height) {
        this.height = height;
        int[] gte = gte(height);
        int[] lt = lt(height);


        int i = 0;
        while (gte[i] < 0){
            i++;
        }

        int next;
        int area = 0;
        while (i < height.length - 1){
            int gteIdx = gte[i];
            if (gteIdx > 0){
                next = gteIdx;
            }else {
                next = lt[i];
            }
            area += calculateArea(height, i, next);
            i = next;
        }

        return area;
    }

    private int calculateArea(int[] height, int i, int j) {
        int area = 0;
        int min = Math.min(height[i], height[j]);
        for (int k = i + 1; k <  j ; k++) {
            area += min - height[k];
        }
        return area;
    }

    private int[] gte(int[] arr){
        int[] gte = new int[arr.length];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                gte[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            gte[stack.pop()] = -1;
        }
        return gte;
    }

    private int[] lt(int[] arr){
        int[] lt = new int[arr.length];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() !=0 && arr[stack.peek()] > arr[i]){
                lt[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            lt[stack.pop()] = -1;
        }
        return lt;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        Q42 test = new Q42();
        System.out.println(test.trap(arr));
    }
}
