package DSA.leetcode;


import java.util.Arrays;
import java.util.Stack;

public class Q739 {

    public int[] dailyTemperatures(int[] temperatures) {

        int[] answer = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < temperatures.length; i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int lIdx = stack.pop();
                answer[lIdx] = i - lIdx;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()){
            answer[stack.pop()] = 0;
        }

        return answer;
    }


    public static void main(String[] args) {
        Q739 test = new Q739();
        int[] arr = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(test.dailyTemperatures(arr)));
    }
}
