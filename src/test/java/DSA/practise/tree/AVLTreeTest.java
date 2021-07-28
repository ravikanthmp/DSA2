package DSA.practise.tree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AVLTreeTest {

    @Test
    public void testAVLSorted_200(){

        int[] ints = randomArr(200);
        AVLTree<Integer> tree = new AVLTree<>();
        Arrays.stream(ints).forEach(tree::add);
        assertTrue(isSorted(tree));

    }


    @Test
    public void testAVLSorted_2000(){

        int[] ints = randomArr(2000);
        AVLTree<Integer> tree = new AVLTree<>();
        Arrays.stream(ints).forEach(tree::add);
        assertTrue(isSorted(tree));

    }

    @Test
    public void testAVLSorted_20000(){

        int[] ints = randomArr(20000);
        AVLTree<Integer> tree = new AVLTree<>();
        Arrays.stream(ints).forEach(tree::add);
        assertTrue(isSorted(tree));

    }


    @Test
    public void testAVLHeight_2000(){
        int N = 20000;
        int[] ints = randomArr(N);
        AVLTree<Integer> tree = new AVLTree<>();
        Arrays.stream(ints).forEach(tree::add);
        assertTrue(tree.height() <= log2(N) * 1.5);
    }

    private boolean isSorted(AVLTree<Integer> tree){
        Integer prev = null;
        for (Integer integer : tree.inOrder()) {
            if (prev == null){
                prev = integer;
            }else {
                if (integer.compareTo(prev) <= 0){
                    return false;
                }
                prev = integer;
            }
        }

        return true;

    }

    public static int log2(int N)
    {

        // calculate log2 N indirectly
        // using log() method
        int result = (int)(Math.log(N) / Math.log(2));

        return result;
    }

    private int[] randomArr(int N){
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * N);
        }
        return arr;
    }
}