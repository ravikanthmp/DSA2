package DSA.practise.arrays;

import java.util.Arrays;
import java.util.Iterator;

public class DynamicArray<T> implements Iterable<T> {

    private int capacity ;
    private int length = 0;
    private T[] arr;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public DynamicArray(){
        this(50);
    }

    public int size(){
        return length;
    }

    public void resize(int newSize){
        T[] temp = (T[]) new Object[newSize];

        for (int i = 0; i < length; i++) {
            temp[i] = arr[i];
        }

        capacity = newSize;
        arr = temp;
    }


    public void add(T item){
        if (length == capacity){
            resize(2*capacity);
        }
        arr[length++] = item;
    }

    public T get(int idx){
        if (idx < 0 || idx >= length ){
            throw new IllegalArgumentException("Invalid index " + idx);
        }
        return arr[idx];
    }


    public void remove(int idx){
        if (idx < 0 || idx >= length ){
            throw new IllegalArgumentException("Invalid index " + idx);
        }

        arr[idx] = null;
        for (int i = idx; i < length - 1; i++){
            arr[i] = arr[i+1];
        }
        arr[length - 1] = null;
        length--;

        if (length>4 && length <= capacity/4 ){
            resize(capacity/2);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int idx = 0;

            @Override
            public boolean hasNext() {
                return idx < length;
            }

            @Override
            public T next() {
                return arr[idx++];
            }
        };
    }

    @Override
    public String toString() {
        return "DynamicArray{" +
                "capacity=" + capacity +
                ", length=" + length +
                ", arr=" + Arrays.toString(arr) +
                '}';
    }

    public static void main(String[] args) {

        DynamicArray<Integer> arr = new DynamicArray<Integer>(1);

        for (int i = 0; i < 100; i++) {
            arr.add(i);
            System.out.println(arr);
        }

        for (int i = 0; i < 100; i++) {
            arr.remove(arr.size() - 1);
            System.out.println(arr);
        }
    }

    /*
    Watch out for
    a. add() -> resize shouldn't have been in else block.

        WRONG
        if(){
            resize()
        }else{
           <insert logic>
        }

        CORRECT

        if(){
            resize()
        }
        <insert logic>

     */
}