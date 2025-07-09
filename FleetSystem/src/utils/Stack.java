package src.utils;

public class Stack<T> {
    private LinkedList<T> list;

    public Stack() {
        list = new LinkedList<>();
    }

    public void push(T data) {
        list.add(data);
    }

    public T pop() {
        return list.remove();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
