package DSA.leetcode;

import DSA.practise.stack.Stack;

public class Q20 {

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

    public boolean isValid(String s) {

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

    public static void main(String[] args) {
        Q20 test = new Q20();
        System.out.println(test.isValid("{[]}"));
    }
}