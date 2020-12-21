import java.util.ArrayList;
import java.util.Collections;

public class QuickSort {

    private static <T extends Comparable<T>> int partition(ArrayList<T> data, int start, int end) {
        int mid = (start + end) / 2;
        T pivot = data.get(mid);
        Collections.swap(data, start, mid);
        int next = start;

        for (int i = start + 1; i <= end; i++) {
            if (data.get(i).compareTo(data.get(start)) < 0) {
                next++;
                Collections.swap(data, i, next);
            }
        }

        Collections.swap(data, start, next);
        return next;
    }

    private static <T extends Comparable<T>> void quickSort(ArrayList<T> data, int start, int end) {
        if (start < end) {
            int splitIndex = partition(data, start, end);
            quickSort(data, start, splitIndex - 1);
            quickSort(data, splitIndex + 1, end);
        }
    }

    public static <T extends Comparable<T>> void quickSort(ArrayList<T> data) {
        quickSort(data, 0, data.size() - 1);
    }
}
