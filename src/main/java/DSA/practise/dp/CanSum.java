package DSA.practise.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CanSum {

    private int[] arr;
    private int finalSum;
    private Map<Integer, Boolean> dp = new HashMap<>();
    private boolean canSum;

    public CanSum(int[] arr, int finalSum) {
        this.arr = arr;
        this.finalSum = finalSum;
        this.canSum = canSum(finalSum);

    }

    public boolean canSum(){
        return canSum;
    }

    private boolean canSum(int sum){
        if (sum < 0) return false;
        if (sum == 0) return true;
        if (dp.containsKey(sum)) return dp.get(sum);
        boolean ans = false;
        for (int a : arr) {
            int partialSum = sum - a;
            ans = canSum(partialSum);
            if (ans) {
                break;
            };
        }

        dp.put(sum, ans);
        return dp.get(sum);
    }

    public static void main(String[] args) {
        int[] arr = {5,3,4, 7};
        CanSum canSum = new CanSum(arr, 7);
        System.out.println(canSum.canSum());

    }
}
