package DSA.practise.dp.memoization;

import java.util.*;

public class BestSum {

    private int[] arr;
    private int finalSum;
    private List<Integer> result ;
    private Map<Integer, Integer> dp = new HashMap<>();

    public BestSum(int[] arr, int finalSum){
        this.arr = arr;
        this.finalSum = finalSum;
        test(finalSum, new ArrayList<Integer>());
    }

    private void test(int remaining, ArrayList<Integer> soFar) {
        if(remaining < 0){
            return;
        }else if (remaining == 0) {
            if (result == null || result.size() > soFar.size()) {
                result = new ArrayList<>(soFar);
            }
        }
        for (int el : arr) {
            soFar.add(el);
            test(remaining - el, soFar);
            soFar.remove(soFar.size() - 1);
        }
    }


    public Integer[] getResult(){
        return result.toArray(new Integer[result.size()]);
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4};
        BestSum howSum = new BestSum(arr, 8);
        System.out.println(Arrays.toString(howSum.getResult()));
    }
}
