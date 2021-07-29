package DSA.practise.string;

import java.util.Arrays;
import java.util.Objects;

public class LSDRadixSort {

    public static LSDRadixSort newInstance() {
        LSDRadixSort lsdRadixSort = new LSDRadixSort();
        return lsdRadixSort;
    }

    public void sort(String[] s){
        Objects.requireNonNull(s);
        int W = s[0].length();
        int R = 256;

        String[] aux;
        int[] count;


        for (int col = W - 1; col >= 0 ; col--) {

            aux = new String[s.length];
            count = new int[R + 1];

            for (int i = 0; i < s.length; i++) {
                count[s[i].charAt(col) + 1]++;
            }

            for (int i = 0; i < R; i++) {
                count[i + 1]+= count[i];
            }

            for (int i = 0; i < s.length; i++) {
                aux[count[s[i].charAt(col)]++] = s[i];
            }

            for (int i = 0; i < s.length; i++) {
                s[i] = aux[i];
            }
        }
    }

    public static void main(String[] args) {
        String[] s = {"ravi", "kanth"};

        LSDRadixSort lsdRadixSort = LSDRadixSort.newInstance();
        lsdRadixSort.sort(s);
        System.out.println(Arrays.toString(s));
    }
}
