package DSA.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Q146 {

    static class Node{
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val, Node next, Node prev) {
            this.key = key;
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

        public Node(){
            this(0, 0, null,null);
        }

    }

    static class DLL{
        Node dummyHead;
        Node dummyTail;

        DLL(){
            this.dummyHead = new Node();
            this.dummyTail = new Node();
            dummyTail.prev = dummyHead;
            dummyHead.next = dummyTail;
        }

        Node delete(Node node){

            Node prev = node.prev;
            Node next = node.next;
            node.next = null;
            node.prev = null;

            prev.next = next;
            next.prev = prev;
            return node;
        }

        Node addLast(int k, int v){
            Node node = new Node(k, v, dummyTail, dummyTail.prev);
            node.prev.next = node;
            node.next.prev = node;
            return node;
        }

        Node deleteFirst(){
           return delete(dummyHead.next);
        }
    }

    public static class LRUCache {

        Map<Integer, Node> map = new HashMap<>();
        DLL dll = new DLL();

        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)){
                return map.get(key).val;
            }else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (map.containsKey(key)){
                Node node = map.get(key);
                dll.delete(node);
                Node newNode = dll.addLast(key, value);
                map.put(key, newNode);
            }else {
                if (map.size() == capacity){
                    Node node = dll.deleteFirst();
                    map.remove(node.key);
                }
                Node node = dll.addLast(key, value);
                map.put(key, node);
            }
        }

    }


    public static void main(String[] args) {
        Q146.LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }
}
