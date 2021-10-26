package DSA.leetcode.topInterview.medium;

import java.util.Stack;

public class FindTheCelebrity {

    public int findCelebrity(int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.add(i);
        }

        while (stack.size() > 1){
            Integer i = stack.pop();
            Integer j = stack.pop();

            if (knows(i, j)){
                stack.push(j);
            }else {
                stack.push(i);
            }

        }

        Integer possibleCeleb = stack.pop();

        for (int i = 0; i < n; i++) {
            if (i == possibleCeleb){
                continue;
            }else {
                if (knows(possibleCeleb, i)){
                    return -1;
                }
                if (!knows(i, possibleCeleb)){
                    return -1;
                }
            }
        }

        return possibleCeleb;
    }

    boolean knows(int a, int b){
        return true;
    }
    
}
