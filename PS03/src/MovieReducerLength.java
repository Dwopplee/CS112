import java.util.ArrayList;

public class MovieReducerLength implements MediaReducer {

    public String reduce(ArrayList<Media> list, String key) {
        int length = Integer.parseInt(key);
        ArrayList<Media> matches = new ArrayList<Media>(0);

        for(int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().length() == length) {
                matches.add(list.get(i));
            }
        }

        StringBuilder output = new StringBuilder(0);

        for (int i = 0; i < matches.size(); i++) {
            output.append(String.format("%5d %-55s %-15s\n", matches.get(i).getYear(), matches.get(i).getName(),
                    matches.get(i).getGenre()));
        }

        return output.toString();
    }

}
