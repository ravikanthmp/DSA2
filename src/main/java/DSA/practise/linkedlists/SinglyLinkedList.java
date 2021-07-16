package DSA.practise.linkedlists;

import java.util.Iterator;

public class SinglyLinkedList<T> implements List<T>{

    class Node{
        T value;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }

        Node next;
    }

    Node head;
    Node tail;

    @Override
    public void addLast(T val) {
        Node node = new Node(val, null);
        if (isEmpty()){
            head = node;
            tail = node;
        }else {
            tail.next = node;
            tail = tail.next;
        }
    }

    @Override
    public void addFirst(T val) {
        Node node = new Node(val, null);
        if (isEmpty()){
            head = node;
            tail = node;
        }else {
            node.next = head;
            head = node;
        }
    }

    @Override
    public T removeFirst() {

        if (isEmpty()){
            throw new UnsupportedOperationException("Removefirst on an empty list");
        }

        T val = head.value;;
        if (head == tail){
            head = null;
            tail = null;
        }else {
            Node old = head;
            head = old.next;
            old.next = null;
            old = null;
        }
        return null;
    }

    @Override
    public T removeLast() {

        if (isEmpty()){
            throw new UnsupportedOperationException("Removelast on an empty list");
        }

        T val = tail.value;
        if (head == tail){
            head = null;
            tail = null;
        }else {

            Node prev = null;
            Node curr;
            for(curr = head; curr != tail; curr = curr.next){
                prev = curr;
            }
            prev.next = null;
            tail = prev;
        }
        return val;
    }

    @Override
    public int size() {
        int size = 0;
        for (Node curr = head; curr != null; curr = curr.next){
            size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return ((head == null) && (tail == null));
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            Node curr = head;
            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                T val = curr.value;
                curr = curr.next;
                return val;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node curr = head; curr != null; curr = curr.next){
            sb.append(curr.value).append(" ");
        }
        return String.format("SinglyLinkedList{list=%s,size=%d}", sb.toString(), size());
    }

    public static void main(String[] args) {
        List<Integer> list = new SinglyLinkedList<>();

        for (int i = 0; i < 10; i++) {
            list.addFirst(i);
            System.out.println(list);
        }

        for (int i = 0; i < 10; i++) {
            list.removeFirst();
            System.out.println(list);
        }

        for (int i = 0; i < 10; i++) {
            list.addLast(i);
            System.out.println(list);
        }

        for (int i = 0; i < 10; i++) {
            list.removeLast();
            System.out.println(list);
        }
    }
}
