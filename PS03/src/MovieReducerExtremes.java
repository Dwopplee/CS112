import java.util.ArrayList;

public class MovieReducerExtremes implements MediaReducer {

    public String reduce(ArrayList<Media> list, String key) {
        int extreme = 0;

        if (key.equalsIgnoreCase("newest")) {
            for(int i = 1; i < list.size(); i++) {
                if (list.get(i).wasReleasedAfter(list.get(extreme))) {
                    extreme = i;
                }
            }
        } else if (key.equalsIgnoreCase("oldest")) {
            for(int i = 1; i < list.size(); i++) {
                if (list.get(i).wasReleasedBeforeOrInSameYear(list.get(extreme))) {
                    extreme = i;
                }
            }
        } else {
            extreme = -1;
        }

        if (extreme != -1) {
            Media extremeMedia = list.get(extreme);

            return String.format("%5d %-56s%-15s", extremeMedia.getYear(), extremeMedia.getName(),
                    extremeMedia.getGenre());
        } else {
            return "Invalid key";
        }

    }

}
