package DSA.practise.dp.tabulation;

import java.util.Arrays;
import java.util.stream.Stream;

public class CanSum {

    private final int target;
    private int[] arr;
    private boolean[] tab;

    public CanSum(int target, int[] arr) {
        this.target = target;
        this.arr = arr;

        doIt();
    }

    private void doIt() {
        this.tab = new boolean[target + 1];
        tab[0] = true;

        for (int i = 0; i < tab.length; i++) {
            if (tab[i]){
                for (int num : arr) {
                    if (i + num < tab.length){
                        tab[i + num] = true;
                    }
                }
            }
        }
    }

    public boolean test(){
        return tab[target];
    }

    public static void main(String[] args) {
        int[] arr = {5,3};
        CanSum canSum = new CanSum(19, arr);
        System.out.println(canSum.test());
        System.out.println(Arrays.toString(canSum.tab));
    }
}
