import java.util.ArrayList;

public class MovieReducerEraCount implements MediaReducer {

    public String reduce(ArrayList<Media> list, String key) {
        int count = 0;

        for(int i = 0; i < list.size(); i++) {
            if (list.get(i).getEra().equals(key)) {
                count++;
            }
        }

        return String.format("Movies in %s: %d", key, count);
    }

}
