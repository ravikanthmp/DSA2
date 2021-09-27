package DSA.leetcode.virtual.sep182021;

public class Q2011 {

    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String operation : operations) {
            x = apply(x, operation);
        }
        return x;
    }

    private int apply(int x, String op){
        if (op.contains("++")){
            return x + 1;
        }else {
            return x - 1;
        }
    }

    public static void main(String[] args) {
        String[] op = {"++X","++X","X++"};
        Q2011 test = new Q2011();
        System.out.println(test.finalValueAfterOperations(op));
    }

}
