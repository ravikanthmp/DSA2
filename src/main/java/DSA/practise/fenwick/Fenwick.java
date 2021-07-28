package DSA.practise.fenwick;

import java.util.Arrays;

public class Fenwick {

    private int[] arr;

    public Fenwick(int[] a) {
        System.out.println(Arrays.toString(a));
        arr = new int[a.length + 1];
        for (int i = 0; i < a.length; i++) {
            arr[i + 1] = a[i];
        }

        for (int i = 1; i < arr.length; i++) {
            int immParent = i + Integer.lowestOneBit(i);
            if (immParent < arr.length){
                arr[immParent] += arr[i];
            }
        }
    }

    @Override
    public String toString() {
        return "Fenwick{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }


    public int rangeSum(int i, int j){
        return arr[i + 1] - arr[j];
    }

    public void update(int idx, int newVal){

        int newIdx = idx + 1;
        if (newIdx >= arr.length){
            throw new IllegalArgumentException("Cannot update index" + idx);
        }
        int diff = newVal - arr[newIdx];

        while (newIdx < arr.length){
            arr[newIdx] += diff;
            newIdx += Integer.lowestOneBit(newIdx);
        }
    }


    public int prefixSum(int i){
        int newIdx = i + 1;
        int sum = 0;
        while (newIdx > 0){
            sum+=arr[newIdx];
            newIdx-=Integer.lowestOneBit(newIdx);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = {3, 4, -2, 7, 3, 11, 5, -8, -9, 2, 4, -8};
        Fenwick fenwick = new Fenwick(a);
        System.out.println(fenwick);
        System.out.println(fenwick.prefixSum(3));

    }
}
