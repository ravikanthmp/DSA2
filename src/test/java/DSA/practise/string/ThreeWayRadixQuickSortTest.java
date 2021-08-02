package DSA.practise.string;

import DSA.practise.Util;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ThreeWayRadixQuickSortTest {

    @Test
    void sortSmall() throws Exception {
        String words3 = "https://algs4.cs.princeton.edu/51radix/shells.txt";
        String[] strings = Util.readInputStringArray(words3);
        System.out.println(Arrays.toString(strings));
        ThreeWayRadixQuickSort threeWayRadixQuickSort = ThreeWayRadixQuickSort.newInstance();
        threeWayRadixQuickSort.sort(strings);
        assertTrue(Util.isSorted(strings));
    }

    @Test
    void sortMedium() throws Exception {
        String words3 = "https://algs4.cs.princeton.edu/51radix/shells.txt";
        String[] strings = Util.readInputStringArray(words3);
        System.out.println(Arrays.toString(strings));
        ThreeWayRadixQuickSort threeWayRadixQuickSort = ThreeWayRadixQuickSort.newInstance();
        threeWayRadixQuickSort.sort(strings);
        assertTrue(Util.isSorted(strings));
    }

}