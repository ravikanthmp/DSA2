package DSA.practise.dp.tabulation;

import java.util.ArrayList;
import java.util.List;

public class HowSum {

    private final int target;
    private final int[] arr;

    private List<Integer>[] howTab;
    private boolean[] tab;
    
    public HowSum(int target, int[] arr) {

        this.target = target;
        this.arr = arr;
        howTabulate();
    }
    
    private void howTabulate(){
        this.howTab = new ArrayList[target + 1];
        this.tab = new boolean[target + 1];
        tab[0] = true;
        howTab[0] = new ArrayList<>();

        for (int i = 0; i <= target; i++) {
            if (tab[i]){
               extend(i, tab, howTab);
            }
        }
    }

    private void extend(int i, boolean[] tab, List[] howTab){
        for (int j = 0; j < arr.length; j++) {
            int nextIdx = i + arr[j];
            if (nextIdx <= target){
                tab[nextIdx] = true;
                howTab[nextIdx] = deepClone(howTab[i]);
                howTab[nextIdx].add(arr[j]);
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
        int[] arr = {2, 3, 5};
        HowSum howSum = new HowSum(17, arr);
        System.out.println(howSum.getHow());
    }
}
