package DSA.practise.linkedlists;

public interface List<T> extends Iterable<T>{
    public void addLast(T node);
    public void addFirst(T node);
    public T removeFirst();
    public T removeLast();
    public int size();
    public boolean isEmpty();
}
