package src.utils;

import java.util.ArrayList;

public class PriorityQueue<T extends Comparable<T>> {
    private ArrayList<T> heap;

    public PriorityQueue() {
        heap = new ArrayList<>();
    }

    // Add element to the priority queue (heap)
    public void enqueue(T data) {
        heap.add(data);
        heapifyUp(heap.size() - 1);
    }

    // Remove the element with the highest priority (min element)
    public T dequeue() {
        if (heap.isEmpty()) {
            return null;
        }

        T result = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        heapifyDown(0);
        return result;
    }

    // Helper method to maintain heap property after adding an element
    private void heapifyUp(int index) {
        while (index > 0 && heap.get(index).compareTo(heap.get(parent(index))) < 0) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    // Helper method to maintain heap property after removing an element
    private void heapifyDown(int index) {
        int left = leftChild(index);
        int right = rightChild(index);
        int smallest = index;

        if (left < heap.size() && heap.get(left).compareTo(heap.get(smallest)) < 0) {
            smallest = left;
        }

        if (right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) < 0) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // Check if the heap is empty
    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
