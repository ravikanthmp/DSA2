package DSA.leetcode.topInterview.easy;

import java.util.Stack;

public class MinStack {

    class Tuple{
        private final int val;
        private final int min;

        public Tuple(int val, int min) {

            this.val = val;
            this.min = min;
        }
    }

    Stack<Tuple> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()){
            Tuple tuple = new Tuple(val, val);
            stack.push(tuple);
        }else {
            Tuple tuple = new Tuple(val, Math.min(stack.peek().min, val));
            stack.push(tuple);
        }

    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }

}
