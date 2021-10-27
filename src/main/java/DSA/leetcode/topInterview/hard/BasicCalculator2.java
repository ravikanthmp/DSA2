package DSA.leetcode.topInterview.hard;

import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;
import java.util.function.BinaryOperator;

public class BasicCalculator2 {

    enum Operator{
        PLUS('+', 0, (a, b) -> a + b),
        MINUS('-', 0, (a, b) -> a - b),
        MULTIPLY('*', 1, (a, b) -> a * b),
        DIVIDE('/', 1, (a, b) -> a / b),
        ILLEGAL('?', -1, (a, b) -> a);

        private final char c;
        private final int priority;
        private BinaryOperator<Integer> op;

        Operator(char c, int priority, BinaryOperator<Integer> op) {
            this.c = c;
            this.priority = priority;
            this.op = op;
        }

        public static Operator parse(char ch){
            for (Operator op : Operator.values()) {
                if (op.c == ch){
                    return op;
                }
            }
            return ILLEGAL;
        }
    }
    public int calculate(String s) {

        Set<Character> allowedOperators = Set.of('-', '+', '*', '/');

        LinkedList<Integer> operands = new LinkedList<>();
        LinkedList<Operator> operator = new LinkedList<Operator>();
        Integer prevOperand = null;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (curr == ' '){
                continue;
            }
            if (allowedOperators.contains(curr)){
                if (prevOperand != null){
                    operands.push(prevOperand);
                    prevOperand = null;
                }
                Operator oper = Operator.parse(curr);
                if (!operator.isEmpty() &&  oper.priority <= operator.peek().priority){
                    Operator pop = operator.pop();
                    Integer operand2 = operands.pop();
                    Integer operand1 = operands.pop();
                    Integer result = pop.op.apply(operand1, operand2);
                    operands.push(result);
                }
                operator.push(oper);
            }else {
                int intVal = curr - '0';
                if (prevOperand == null){
                    prevOperand = intVal;
                }else {
                    prevOperand = prevOperand*10 + intVal;
                }
            }
        }

        if (prevOperand != null){
            operands.push(prevOperand);
        }

        if (!operator.isEmpty()){
            if (operator.getLast().equals(Operator.DIVIDE) || operator.getLast().equals(Operator.MULTIPLY)){
                int op2 = operands.removeLast();
                int op1 = operands.removeLast();
                Integer res = operator.removeLast().op.apply(op1, op2);
                operands.addLast(res);
            }
        }

        while (operands.size() != 1){
            Operator pop = operator.removeFirst();
            Integer operand2 = operands.removeFirst();
            Integer operand1 = operands.removeFirst();
            Integer result = pop.op.apply(operand1, operand2);
            operands.addFirst(result);
        }
        return operands.pop();
    }


    public static void main(String[] args) {
        BasicCalculator2 calc = new BasicCalculator2();
        System.out.println(calc.calculate("1*2-3/4+5*6-7*8+9/10"));
    }

}
