package DSA.practise.sorting;

import com.google.common.base.Stopwatch;
import org.junit.Assert;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class ThreeWayQuickSort {

    public static ThreeWayQuickSort newInstance() {
        return new ThreeWayQuickSort();
    }

    public void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int pivotElement = a[lo];
        int lt = lo;
        int gt = hi;
        int i = lo;
        while (i <= gt) {
            int cmp = Integer.compare(a[i], pivotElement);
            if (cmp < 0) {
                exch(a, lt++, i++);
            } else if (cmp == 0) {
                i++;
            } else {
                exch(a, i, gt--);
            }
        }

        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int[] randomArr(int N) {
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * N);
        }
        return arr;
    }

    public static boolean isSorted(int[] ints) {
        int prev = ints[0];
        int curr;
        for (int i = 1; i < ints.length; i++) {
            curr = ints[i];
            if (curr < prev) {
                return false;
            }
            prev = curr;
        }
        return true;
    }

    public static void main(String[] args) {

        for (int i = 0, arrSize = 10; i < 5; i++, arrSize*=10) {

            int[] ints = randomArr(arrSize);

            Stopwatch stopwatch =  Stopwatch.createStarted();

            ThreeWayQuickSort threeWayQuickSort = ThreeWayQuickSort.newInstance();
            threeWayQuickSort.sort(ints);

            Assert.assertTrue(isSorted(ints));
            System.out.println(String.format("Time took = %d for array size = %d", stopwatch.elapsed(TimeUnit.MILLISECONDS), arrSize));
        }
    }
}
