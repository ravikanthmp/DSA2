package DSA.practise.linkedlists;

import java.util.Iterator;

public class DoublyLinkedList<T> implements List<T> {

    class Node{
        T value;

        public Node(T value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }

        Node next;
        Node prev;
    }

    Node head;
    Node tail;

    @Override
    public void addLast(T val) {
        Node node = new Node(val, null, null);
        if (isEmpty()){
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }
    }

    @Override
    public void addFirst(T val) {
        Node node = new Node(val, null, null);
        if (isEmpty()){
            head = node;
            tail = node;
        }else {
           head.prev = node;
           node.next = head;
           head = head.prev;
        }
    }

    @Override
    public T removeFirst() {

        if (isEmpty()){
            throw new UnsupportedOperationException("Removefirst on an empty list");
        }
        T value;
        if (head == tail){
            value = head.value;
            head = null;
            tail = null;
        }else {
            Node old = head;
            value = old.value;
            head = old.next;
            old.next = null;
            head.prev = null;
        }
        return value;
    }

    @Override
    public T removeLast() {

        if (isEmpty()){
            throw new UnsupportedOperationException("Remove last on an empty list");
        }
        T val = tail.value;
        if (head == tail){
            head = null;
            tail = null;
        }else {
            Node tmp = tail.prev;
            tmp.next = null;
            tail.prev = null;
            tail = tmp;
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
        return String.format("DoublyLinkedList{list=%s,size=%d}", sb.toString(), size());
    }

    public static void main(String[] args) {
        List<Integer> list = new DoublyLinkedList<>();

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
