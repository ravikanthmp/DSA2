package DSA.practise.queue;

import java.util.List;;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class PriorityQueue<T extends Comparable<T>> implements Iterable<T>{

    private List<T> internalList;
    private Comparator<T> comparator;

    public PriorityQueue(){
        this(50, null);
    }

    public PriorityQueue(Comparator<T> comparator){
        this(50, comparator);
    }

    public PriorityQueue(int n, Comparator<T> comparator){
        internalList = new ArrayList<>(n);
        this.comparator = comparator;
    }

    private Integer compare(int i, int j){
        T a = internalList.get(i);
        T b = internalList.get(j);
        if (comparator != null){
            return comparator.compare(a, b);
        }else {
            return a.compareTo(b);
        }
    }

    private boolean less(int i, int j){
        return compare(i, j) < 0;
    }

    private void exchange(int i, int j){
        T tmp = internalList.get(i);
        internalList.set(i, internalList.get(j));
        internalList.set(j, tmp);
    }

    private void sink(int i){

        while (i < internalList.size()){
            int childLeft = 2*i + 1;
            int childRight = 2*i + 2;
            int smallerChild = childLeft;
            if (childRight < internalList.size() &&  less(childRight, childLeft)){
                smallerChild = childRight;
            }

            if (smallerChild < internalList.size() && less(smallerChild, i)){
                exchange(i, smallerChild);
                i = smallerChild;
            }else {
                return;
            }
        }
    }

    private int getSiblingIndex(int i){
        if(i % 2 == 0){
            return i - 1;
        }else {
            return i + 1;
        }
    }

    private void swim(int i){
        while (i > 0){

            int parent = (i - 1)/2;
            int smallerChild = i;
            int sibling = getSiblingIndex(smallerChild);
            if (sibling < internalList.size() && less(sibling, i)){
                smallerChild = sibling;
            }

            if (less(smallerChild, parent)){
                exchange(smallerChild, parent);
                i = parent;
            }else {
                break;
            }


        }
    }

    public void add(T item){
        internalList.add(internalList.size(), item);
        swim(internalList.size() - 1);
    }

    public T remove(){
        exchange(0, internalList.size() - 1);
        T removed = internalList.remove(internalList.size() - 1);
        sink(0);
        return removed;
    }

    private boolean isEmpty() {
        return internalList.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return internalList.iterator();
    }

    @Override
    public String toString() {
        return "PriorityQueue{" +
                "internalList=" + internalList +
                '}';
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for (int i = 0; i < 10; i++) {
            int  v = (int) (Math.random() * 100);
            pq.add(v);
            System.out.println("added :" + v + " " + pq);
        }

        while (!pq.isEmpty()){
            Integer min = pq.remove();
            System.out.println("Min:" + min + " " + pq);
        }
    }
}