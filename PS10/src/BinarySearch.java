import java.util.ArrayList;

public class BinarySearch {

    public static <T extends Comparable<T>> int findLeftmost (ArrayList<T> data, T target) {
        int left = 0;
        int right = data.size() - 1;
        int mid;

        if (data.get(left).compareTo(target) > 0) {
            return -1;
        } else {
            while (left < right) {
                mid = (left + right) / 2;
                if (data.get(mid).compareTo(target) < 0) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return left;
        }
    }

    public static int findLeftmostString (ArrayList<String> data, String target) {
        int left = 0;
        int right = data.size() - 1;
        int mid;

        if (left >= right) {
            return -1;
        } else {
            while (left < right) {
                mid = (left + right) / 2;
                if (data.get(mid).compareToIgnoreCase(target) < 0) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return left;
        }
    }

}
