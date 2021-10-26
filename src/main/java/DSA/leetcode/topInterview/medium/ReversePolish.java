package DSA.leetcode.topInterview.medium;

import java.util.Stack;

public class ReversePolish {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();


        for (String token : tokens) {
            if (token.equals("+" ) || token.equals("*") || token.equals("/") || token.equals("-")){


                int operand2 = stack.pop();
                int operand1 = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        stack.push(operand1 / operand2);
                        break;
                }



            }else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
