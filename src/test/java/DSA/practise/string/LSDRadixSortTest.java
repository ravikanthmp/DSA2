package DSA.practise.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static DSA.practise.Util.isSorted;
import static DSA.practise.Util.readInputStringArray;

class LSDRadixSortTest {

    @Test
    void sortSmall() throws Exception {
        String words3 = "https://algs4.cs.princeton.edu/51radix/words3.txt";
        testSorted(words3);
    }

    private void testSorted(String words3) throws Exception {
        String[] strings = readInputStringArray(words3);
        LSDRadixSort lsdRadixSort = LSDRadixSort.newInstance();
        lsdRadixSort.sort(strings);
        System.out.println(Arrays.toString(strings));
        Assertions.assertTrue(isSorted(strings));
    }

    @Test
    void sort10000() throws Exception {
        String words3 = "https://introcs.cs.princeton.edu/java/data/leipzig/leipzig100k.txt";
        testSorted(words3);
    }

}