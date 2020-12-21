import java.util.ArrayList;
import java.util.HashMap;

public class HashCollector {

    private ArrayList<Integer> collection = new ArrayList<>(0);
    private HashMap<Integer, String> map = new HashMap<>(0);

    public void add (String input) {
        Integer hash = HashGen.makeHash(input);

        if (collection.size() > 0) {
            int index = BinarySearch.findLeftmost(collection, hash);

            if (index == -1) {
                collection.add(0, hash);
                map.put(hash, input);
            } else {
                if (hash.compareTo(collection.get(index)) > 0) {
                    collection.add(index + 1, hash);
                    map.put(hash, input);
                } else if (hash.compareTo(collection.get(index)) < 0) {
                    collection.add(index, hash);
                    map.put(hash, input);
                }
            }
        } else {
            collection.add(hash);
            map.put(hash, input);
        }
    }

    public void printCollection() {
        for (int hash : collection) {
            System.out.printf("Hash: %d Word: %s%n", hash, map.get(hash));
        }
    }

}
