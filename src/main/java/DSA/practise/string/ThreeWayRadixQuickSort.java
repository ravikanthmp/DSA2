package DSA.practise.string;

import java.util.Arrays;

public class ThreeWayRadixQuickSort {
    public void sort(String[] s){
        sort(s, 0, s.length - 1, 0);
    }

    private void sort(String[] s, int lo, int hi, int d) {
        if (lo >= hi){
            return;
        }
        int i = lo;
        int pivot = charAt(s[lo], d);
        int lt = lo;
        int gt = hi;
        while (i <= gt){
            int cmp = Integer.compare(charAt(s[i], d), pivot);
            if (cmp < 0){
                exch(s, i++, lt++);
            }else if (cmp > 0){
                exch(s, i, gt--);
            }else {
                i++;
            }
        }

        sort(s, lo, lt - 1, d) ;
        if (pivot > 0){
            sort(s, lt, gt, d + 1);
        }
        sort(s, gt + 1, hi, d);
    }

    private void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static int charAt(String s, int d) {
        return d >= s.length() ? -1 : s.charAt(d);
    }


    public static ThreeWayRadixQuickSort newInstance() {
        ThreeWayRadixQuickSort threeWayRadixQuickSort = new ThreeWayRadixQuickSort();
        return threeWayRadixQuickSort;
    }

    public static void main(String[] args) {

        ThreeWayRadixQuickSort threeWayRadixQuickSort = ThreeWayRadixQuickSort.newInstance();
        String[] s = {"ravi", "kanth"};
        threeWayRadixQuickSort.sort(s);
        System.out.println(Arrays.toString(s));

    }
}
