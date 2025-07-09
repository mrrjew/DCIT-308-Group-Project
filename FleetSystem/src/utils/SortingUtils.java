package src.utils;
import java.util.*;

public class SortingUtils {

    // QuickSort algorithm to sort vehicles by mileage
    public static <T extends Comparable<T>> void quickSort(List<T> list) {
        quickSortRecursive(list, 0, list.size() - 1);
    }

    private static <T extends Comparable<T>> void quickSortRecursive(List<T> list, int low, int high) {
        if (low < high) {
            int pi = partition(list, low, high);
            quickSortRecursive(list, low, pi - 1);
            quickSortRecursive(list, pi + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partition(List<T> list, int low, int high) {
        T pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j).compareTo(pivot) <= 0) {
                i++;
                Collections.swap(list, i, j);
            }
        }
        Collections.swap(list, i + 1, high);
        return i + 1;
    }

    // MergeSort algorithm to sort vehicles by fuel usage
    public static <T extends Comparable<T>> void mergeSort(List<T> list) {
        if (list.size() > 1) {
            int mid = list.size() / 2;
            List<T> left = new ArrayList<>(list.subList(0, mid));
            List<T> right = new ArrayList<>(list.subList(mid, list.size()));

            mergeSort(left);
            mergeSort(right);

            merge(list, left, right);
        }
    }

    private static <T extends Comparable<T>> void merge(List<T> list, List<T> left, List<T> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }

    // InsertionSort algorithm for sorting vehicles by driver name (example)
    public static <T extends Comparable<T>> void insertionSort(List<T> list) {
        for (int i = 1; i < list.size(); i++) {
            T key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).compareTo(key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }
}
