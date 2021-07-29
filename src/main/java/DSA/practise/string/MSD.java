package DSA.practise.string;

import java.util.Arrays;

public class MSD {

    private final int R = 256;

    public void sort(String[] a) {
        String[] aux = new String[a.length];
        sort(a, aux, 0, a.length - 1, 0);
    }

    private void sort(String[] a, String[] aux, int lo, int hi, int d) {
        System.out.println(String.format("lo = %d, hi = %d, d = %d, a = %s", lo, hi, d, Arrays.toString(a)));
        if (hi <= lo) {
            return;
        }

        int[] count = new int[R + 1];

        // count arr
        for (int i = lo; i <= hi; i++) {
            count[charAt(a[i], d) + 1]++;
        }

        // count cum sum
        for (int i = 0; i < R; i++) {
            count[i + 1] += count[i];
        }

        // move to aux
        for (int i = lo; i <= hi; i++) {
            aux[lo + count[charAt(a[i], d)]++] = a[i];
        }

        for (int i = lo; i <= hi; i++){
            a[i] = aux[i];
        }

        for (int i = 2; i < R + 1; i++) {
            sort(a, aux, lo + count[i - 1], lo + count[i] - 1, d + 1);
        }
        
        
    }

    private int charAt(String s, int d) {
        if (d >= s.length()) {
            return -1;
        } else {
            return s.charAt(d);
        }
    }

    public static void main(String[] args) {
        String[] s = {"ravi", "kanth"};
        MSD msd = new MSD();
        msd.sort(s);
        System.out.println(Arrays.toString(s));
    }
}
