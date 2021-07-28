package DSA.practise.hashtable;

import java.util.Objects;

public class SeperateChaining<Key, Value> {

    private Node[] arr = new Node[10];

    private static class Node {
        Object key;
        Object value;
        Node next;

        public Node(Object key, Object value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public SeperateChaining() {
    }

    public boolean contains(Key key) {
        return Objects.nonNull(get(key));
    }

    private int mapToIdx(Key key) {
        int hashCode = key.hashCode();
        int idx = (Math.abs(hashCode)) % arr.length;
        idx = idx & 0x7fffffff;
        return idx;
    }

    public Value get(Key key) {

        int idx = mapToIdx(key);
        for (Node a = arr[idx]; a != null; a = a.next) {
            if (a.key.equals(key)) {
                return (Value) a.value;
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        int idx = mapToIdx(key);
        for (Node a = arr[idx]; a != null; a = a.next) {
            if (a.key.equals(key)) {
                a.value = value;
                return;
            }
        }
        arr[idx] = new Node(key, value, arr[idx]);
    }


    public static void main(String[] args) {
        SeperateChaining<Integer, Integer> map = new SeperateChaining<>();
        map.put(1, 11);
        map.put(2, 22);
        map.put(3, 33);

        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(3));

    }
}
