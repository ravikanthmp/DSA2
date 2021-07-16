package DSA.practise.stack;

import DSA.practise.linkedlists.DoublyLinkedList;

public class Stack<T> {
    DoublyLinkedList<T> internalList = new DoublyLinkedList<T>();

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
}
