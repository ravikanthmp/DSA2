package DSA.practise.stack;

public class BracketsCheck {

    private final String s;

    public BracketsCheck(String test) {
        this.s = test;
        stack = new Stack<>();
    }

    private Stack<Bracket> stack;

    public Boolean check() {

        // null -> true
        if (s == null) {
            return true;
        }

        for (char symbol : s.toCharArray()) {
            Bracket bracket = Bracket.parse(symbol).orElseThrow(RuntimeException::new);
            Boolean result;
            if (bracket.isClosing()) {
                if (stack.isEmpty()) {
                    System.out.println(stack);
                    return false;
                }
                Bracket last = stack.pop();
                if (!last.complement().equals(bracket)) {
                    System.out.println(stack);
                    return false;
                }
            } else {
                stack.push(bracket);
            }
        }

        System.out.println(stack);
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        // [{}] -> valid
        String test;

        test = "[{}]";
        BracketsCheck bracketsCheck = new BracketsCheck(test);
        assert bracketsCheck.check();
    }
}
