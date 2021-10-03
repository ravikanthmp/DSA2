package DSA.leetcode.contest.weekly261;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q5892 {

    public boolean stoneGameIX(int[] stones) {
        Map<Integer, List<Integer>> byMod = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            byMod.putIfAbsent(i, new ArrayList<>());
        }
        for (int stone : stones) {
            int rem = stone % 3;
            byMod.get(rem).add(stone);
        }

        boolean aliceTurn = true;
        boolean gameOver = false;

        int sumOfStonesSoFar = 0;

        boolean allStonesRemoved = false;
        int rem = 0;
        while (!gameOver){

            if (byMod.values().stream().allMatch( l -> l.isEmpty()) ){
                allStonesRemoved = true;
                break;
            }

            if (sumOfStonesSoFar != 0){

                rem = sumOfStonesSoFar % 3;
                if (rem == 0){
                    gameOver = true;
                }else if (rem == 1){
                    if (byMod.get(0).isEmpty() && byMod.get(1).isEmpty()){
                        gameOver = true;
                    }else {
                        if (byMod.get(0).isEmpty()){
                            sumOfStonesSoFar += byMod.get(1).remove(0);
                        }else {
                            sumOfStonesSoFar += byMod.get(0).remove(0);
                        }
                    }
                }else {
                    if (byMod.get(0).isEmpty() && byMod.get(2).isEmpty()){
                        gameOver = true;
                    }else {
                        if (byMod.get(0).isEmpty()){
                            sumOfStonesSoFar += byMod.get(2).remove(0);
                        }else {
                            sumOfStonesSoFar += byMod.get(0).remove(0);
                        }
                    }
                }
            }else {
                if (byMod.get(1).isEmpty() && byMod.get(2).isEmpty()){
                    gameOver = true;
                }else {
                    if (byMod.get(1).isEmpty()){
                        sumOfStonesSoFar += byMod.get(2).remove(0);
                    }else {
                        sumOfStonesSoFar += byMod.get(1).remove(0);
                    }
                }
            }

            if (!gameOver){
                aliceTurn = !aliceTurn;
            }

        }

       if (allStonesRemoved){
           return false;
       }else {
           return !aliceTurn;
       }

    }


    public static void main(String[] args) {
        int[] stones = {20,3,20,17,2,12,15,17,4};
        Q5892 test = new Q5892();
        System.out.println(test.stoneGameIX(stones));
    }


}
