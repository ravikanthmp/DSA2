package DSA.practise.queue;

import java.util.*;

public class IndexedPriorityQueue<T extends Comparable<T>> implements Iterable<T> {

    private Comparator<T> cmp;
    private List<T> internalList;
    private Map<T, Set<Integer>> map;

    public IndexedPriorityQueue() {
        internalList = new ArrayList<>(10);
        map = new HashMap<>();
    }

    public IndexedPriorityQueue(Comparator<T> cmp) {
       this();
       this.cmp = cmp;
    }

    public boolean isEmpty() {
        return internalList.isEmpty();
    }

    public Set<Integer> indexOf(T item) {
        return map.getOrDefault(item, new HashSet<>());
    }

    public Integer anyIndexOf(T item){
       return indexOf(item).stream().findAny().orElse(null);
    }

    private boolean less(int i, int j) {
        return less(internalList.get(i), internalList.get(j));
    }

    private boolean less(T i, T j){
        return Objects.isNull(cmp) ? i.compareTo(j) < 0 : cmp.compare(i, j) < 0;
    }

    private void swap(int i, int j) {
        T temp = internalList.get(i);
        internalList.set(i, internalList.get(j));
        internalList.set(j, temp);
        // current mappings
        T itemI = internalList.get(i);
        T itemJ = internalList.get(j);

        if (!map.containsKey(itemI)){
            map.put(itemI, new HashSet<>());
        }

        if (!map.containsKey(itemJ)){
            map.put(itemJ, new HashSet<>());
        }

        Set<Integer> indicesItemI = map.get(itemI);
        Set<Integer> indicesItemJ = map.get(itemJ);

        indicesItemI.remove(j);
        indicesItemI.add(i);
        indicesItemJ.remove(i);
        indicesItemJ.add(j);
    }

    private void swim(int idx) {
        while (idx > 0) {
            int parent = (idx - 1) / 2;
            if (less(idx, parent)) {
                swap(idx, parent);
                idx = parent;
            } else {
                return;
            }
        }
    }

    private int leftChild(int idx) {
        return 2 * idx + 1;
    }

    private int rightChild(int idx) {
        return 2 * idx + 2;
    }

    private void sink(int idx) {
        while (leftChild(idx) < internalList.size()) {
            int leftChild = leftChild(idx);
            int childIdx = leftChild;
            int rightChild = rightChild(idx);
            if (rightChild < internalList.size() && less(rightChild, leftChild)) {
                childIdx = rightChild;
            }
            if (less(childIdx, idx)){
                swap(idx, childIdx);
                idx = childIdx;
            }else {
                return;
            }
        }
    }

    public void add(T item) {
        internalList.add(item);
        if (!map.containsKey(item)){
            map.put(item, new HashSet<>());
        }
        map.get(item).add(internalList.size() - 1);
        swim(internalList.size() -1);
    }

    public T delete(){
        swap(0, internalList.size() - 1);
        T removed = internalList.remove(internalList.size() - 1);

        Set<Integer> indices = map.get(removed);
        indices.remove(internalList.size());

        if (indices.isEmpty()){
            map.remove(removed);
        }
        sink(0);
        return removed;
    }

    public T get(int idx){
        return internalList.get(idx);
    }

    public void set(int idx, T updated){
        if (idx >= internalList.size()){
            throw new IllegalArgumentException("Cannot update index " + idx + "size is " + internalList.size());
        }
        T current = internalList.get(idx);
        if (updated.compareTo(current)  < 0){
            internalList.set(idx, updated);
            swim(idx);
        }else {
            internalList.set(idx, updated);
            sink(idx);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return internalList.listIterator();
    }

    @Override
    public String toString() {
        return "IndexedPriorityQueue{" +
                "internalList=" + internalList +
                ", map=" + map +
                '}';
    }

    public static void main(String[] args) {
        IndexedPriorityQueue<Integer> pq = new IndexedPriorityQueue<>();

        for (int i = 0; i < 3; i++) {
            int  v = (int) (Math.random() * 200);
            pq.add(v);
            System.out.println("added :" + v + " " + pq);
        }

        while (!pq.isEmpty()){
            Integer min = pq.delete();
            System.out.println("Min:" + min + " " + pq);
        }
    }
}
