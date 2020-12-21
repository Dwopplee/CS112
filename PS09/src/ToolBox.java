import java.util.ArrayList;

public class ToolBox implements GenericTools {
    @Override
    public <T> void swap(ArrayList<T> data, int p1, int p2) {
        T tmp = data.get(p1);
        data.set(p1, data.get(p2));
        data.set(p2,tmp);
    }

    @Override
    public <T extends Comparable<T>> void insertionSort(ArrayList<T> data) {
        for (int i = 1; i < data.size(); i++) {
            for (int j = i; j > 0 && data.get(j - 1).compareTo(data.get(j)) > 0; j--) {
                swap(data, j - 1, j);
            }
        }
    }

    @Override
    public <T extends Comparable<T>> ArrayList<T> insertionSort(ArrayList<T> data, int start, int end) {
        ArrayList<T> output = new ArrayList<T>(0);

        for (int i = start; i < end; i++) {
            output.add(data.get(i));
        }

        return output;
    }
}
