package DSA.leetcode;

import java.util.Stack;

public class Q155 {

    class MyTuple{
        int value;
        int min;

        public MyTuple(int value, int min){
            this.value = value;
            this.min = min;
        }
    }

    class MinStack {

        Stack<MyTuple> stack = new Stack<MyTuple>();
        int minSoFar = Integer.MAX_VALUE;

        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int val) {
            minSoFar = Math.min(minSoFar, val);
            MyTuple tuple = new MyTuple(val, minSoFar);
            stack.push(tuple);
        }

        public void pop() {
            MyTuple top = stack.pop();
            if (!stack.isEmpty()){
                minSoFar = stack.peek().min;
            }else {
                minSoFar = Integer.MAX_VALUE;
            }
        }

        public int top() {
            return stack.peek().value;
        }

        public int getMin() {
            return minSoFar;
        }
    }


}
