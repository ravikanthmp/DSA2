package DSA.practise.queue;

import DSA.practise.linkedlists.DoublyLinkedList;
import DSA.practise.linkedlists.List;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {

    private List<T> internalList;

    public Queue() {
        internalList = new DoublyLinkedList<>();
    }

    @Override
    public Iterator<T> iterator() {
        return internalList.iterator();
    }

    public Integer size(){
        return internalList.size();
    }

    public Boolean isEmpty(){
        return internalList.isEmpty();
    }

    public void enque(T item){
        internalList.addLast(item);
    }

    public T deque(){
        if (internalList.isEmpty()){
            throw new UnsupportedOperationException("Cannot deque from empty queue!");
        }
        return internalList.removeFirst();
    }
}
