package DSA.leetcode;


import java.util.Arrays;
import java.util.Stack;

public class Q739 {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] nge = nge(temperatures);
        int[] answer = new int[temperatures.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = (nge[i] == -1) ? 0 : (nge[i] - i);
        }
        return answer;
    }

    private int[] nge(int[] temperatures) {
        int[] nge = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < temperatures.length; i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
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
        Q739 test = new Q739();
        int[] arr = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(test.dailyTemperatures(arr)));
    }
}
