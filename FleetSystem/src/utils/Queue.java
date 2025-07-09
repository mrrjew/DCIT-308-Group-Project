package src.utils;


public class Queue<T> {
    private LinkedList<T> list;

    public Queue() {
        list = new LinkedList<>();
    }

    public void enqueue(T data) {
        list.add(data);
    }

    public T dequeue() {
        return list.remove();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
