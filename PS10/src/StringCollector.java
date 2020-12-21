import java.util.ArrayList;

public class StringCollector {

    private ArrayList<String> collection = new ArrayList<String>(0);

    public void add (String input) {
        int index = BinarySearch.findLeftmostString(collection, input);
        if (index == -1) {
            if (collection.size() != 0) {
                int check = input.compareToIgnoreCase(collection.get(0));
                if (check < 0) {
                    collection.add(0, input);
                } else if (check > 0) {
                    collection.add(input);
                }
            } else {
                collection.add(input);
            }
        } else {
            if (input.compareToIgnoreCase(collection.get(index)) > 0) {
                collection.add(index + 1, input);
            } else if (input.compareToIgnoreCase(collection.get(index)) < 0) {
                collection.add(index, input);
            }
        }
    }

    public void printCollection () {
        for (String string : collection) {
            System.out.println(string);
        }
    }

}
