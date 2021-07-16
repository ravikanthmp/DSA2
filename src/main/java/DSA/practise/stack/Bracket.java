package DSA.practise.stack;

import java.util.Optional;

public enum Bracket {
    LEFT_SQUARE('[', false){
        @Override
        public Bracket complement() {
            return RIGHT_SQUARE;
        }
    },
    RIGHT_SQUARE(']', true){
        @Override
        public Bracket complement() {
            return LEFT_SQUARE;
        }
    },
    LEFT_BRACE('{', false){
        @Override
        public Bracket complement() {
            return RIGHT_BRACE;
        }
    },
    RIGHT_BRACE('}', true){
        @Override
        public Bracket complement() {
            return LEFT_BRACE;
        }
    },
    LEFT_PAREN('(', false){
        @Override
        public Bracket complement() {
            return RIGHT_PAREN;
        }
    },
    RIGHT_PAREN(')', true){
        @Override
        public Bracket complement() {
            return LEFT_PAREN;
        }
    };

    public static Optional<Bracket> parse(Character c){
        for (Bracket bracket : Bracket.values()) {
            if (bracket.symbol.equals(c)){
                return Optional.of(bracket);
            }
        }
        return Optional.empty();
    }

    private final Character symbol;
    private final Boolean isClosing;

    public abstract Bracket complement();

    Bracket(Character c, boolean isClosing) {
        this.symbol = c;
        this.isClosing = isClosing;
    }

    public Boolean isClosing() {
        return isClosing;
    }
}
