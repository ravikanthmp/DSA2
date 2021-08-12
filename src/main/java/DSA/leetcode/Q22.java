package DSA.leetcode;

import DSA.practise.stack.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Q22 {
    private int positions;
    List<String> resultList = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        this.positions = 2 * n;
        fill(new StringBuilder(), n, n);
        return resultList.stream().filter(s -> isValid(s)).collect(Collectors.toList());
    }

    enum Parenthesis {
        BRACKET_LEFT('(', false) {
            @Override
            public Parenthesis complement() {
                return BRACKET_RIGHT;
            }
        },
        BRACKET_RIGHT(')', true) {
            @Override
            public Parenthesis complement() {
                return BRACE_LEFT;
            }
        },
        BRACE_LEFT('{', false) {
            @Override
            public Parenthesis complement() {
                return BRACE_RIGHT;
            }
        },
        BRACE_RIGHT('}', true) {
            @Override
            public Parenthesis complement() {
                return BRACE_LEFT;
            }
        },
        SQUARE_LEFT('[', false) {
            @Override
            public Parenthesis complement() {
                return SQUARE_RIGHT;
            }
        },
        SQUARE_RIGHT(']', true) {
            @Override
            public Parenthesis complement() {
                return SQUARE_LEFT;
            }
        };

        private final char symbol;
        private final boolean closing;

        public boolean isClosing() {
            return closing;
        }

        abstract public Parenthesis complement();

        Parenthesis(char c, boolean closing) {
            this.symbol = c;
            this.closing = closing;
        }

        static Parenthesis parse(char c) {
            switch (c) {
                case '(':
                    return BRACKET_LEFT;
                case ')':
                    return BRACKET_RIGHT;
                case '{':
                    return BRACE_LEFT;
                case '}':
                    return BRACE_RIGHT;
                case '[':
                    return SQUARE_LEFT;
                case ']':
                    return SQUARE_RIGHT;
                default:
                    return null;
            }

        }
    }

    private boolean isValid(String s) {

        Stack<Parenthesis> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            Parenthesis symbol = Parenthesis.parse(c);
            if (!symbol.isClosing()) {
                stack.push(symbol);
            } else {
                boolean fail = stack.isEmpty() || !stack.pop().complement().equals(symbol);
                if (fail) {
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }

    private void fill(StringBuilder sb, int open, int close){
        if (open == 0 && close == 0){
            resultList.add(sb.toString());
        }else{

            if (open < close){
                sb.append(')');
                fill(sb, open, close - 1);
                sb.deleteCharAt(sb.length() - 1);
            }

            if (open > 0){
                sb.append('(');
                fill(sb, open - 1, close);
                sb.deleteCharAt(sb.length() - 1);
            }

        }
    }

    public static void main(String[] args) {
        Q22 test = new Q22();

        System.out.println(test.generateParenthesis(4));;

    }

}
