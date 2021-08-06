package DSA.practise.dp;

import java.util.*;

public class HowSum {

    private int[] arr;
    private int finalSum;
    private List<Integer> result ;
    private Map<Integer, Integer> dp = new HashMap<>();

    public HowSum(int[] arr, int finalSum){
        this.arr = arr;
        this.finalSum = finalSum;
        check(finalSum, new ArrayList<>());
    }

    private boolean check(int remaining, ArrayList<Integer> soFar){

        if (remaining < 0) return false;
        if (remaining == 0 && result == null){
            result = new ArrayList<>(soFar);
            return true;
        }
        boolean ans = false;
        for (int el : arr) {
            soFar.add(el);
            check(remaining - el, soFar);
            soFar.remove(soFar.size() - 1);
            if (ans){
                break;
            }
        }
        return ans;
    }

    public Integer[] getResult(){
        return result.toArray(new Integer[result.size()]);
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 1, 3, 4};
        HowSum howSum = new HowSum(arr, 8);
        System.out.println(Arrays.toString(howSum.getResult()));
    }
}
