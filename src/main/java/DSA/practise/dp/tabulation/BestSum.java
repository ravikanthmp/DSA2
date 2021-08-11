package DSA.practise.dp.tabulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BestSum {

    private final int target;
    private final int[] arr;

    private List<Integer>[] howTab;

    public BestSum(int target, int[] arr) {

        this.target = target;
        this.arr = arr;
        howTabulate();
    }
    
    private void howTabulate(){
        this.howTab = new ArrayList[target + 1];
        howTab[0] = new ArrayList<>();

        for (int i = 0; i <= target; i++) {
            if (howTab[i] != null){
               extend(i, howTab);
            }
        }
    }

    private void extend(int i, List[] howTab){
        for (int j = 0; j < arr.length; j++) {
            int nextIdx = i + arr[j];
            if (nextIdx <= target){
                if (Objects.nonNull(howTab[nextIdx]) && (howTab[nextIdx].size() < howTab[i].size() + 1)){
                    continue;
                }else {
                    howTab[nextIdx] = deepClone(howTab[i]);
                    howTab[nextIdx].add(arr[j]);
                }

            }
        }
    }

    public List<Integer> getHow(){
       return howTab[target];
    }

    private List<Integer> deepClone(List<Integer> orig){
        List<Integer> copy = new ArrayList<>();
        orig.forEach(copy::add);
        return copy;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 9};
        BestSum howSum = new BestSum(27, arr);
        System.out.println(howSum.getHow());
    }
}
