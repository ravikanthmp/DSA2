package DSA.practise.stack;

import DSA.practise.linkedlists.DoublyLinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class Stack<T> implements Iterable<T>{
    LinkedList<T> internalList = new LinkedList<T>();

    public void push(T item){
        internalList.addLast(item);
    }

    @Override
    public String toString() {
        return "Stack{" +
                "internalList=" + internalList +
                '}';
    }

    public T pop(){
        try{
            return internalList.removeLast();
        }catch (Exception e){
            throw new UnsupportedOperationException("Pop called on empty stack!");
        }
    }

   public boolean isEmpty(){
        return internalList.isEmpty();
   }

   public Integer size(){
        return internalList.size();
   }

    @Override
    public Iterator<T> iterator() {
        return internalList.iterator();
    }
}
