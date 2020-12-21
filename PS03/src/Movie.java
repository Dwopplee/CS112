public class Movie extends Media {

    public Movie(String n, int y, String g) {
        super(n, y, g);
    }

    @Override
    public String getEra() {
        if (getYear() >= 2000) {
            return "New Millennium Era";
        } else if (getYear()  >= 1977) {
            return "Modern Era";
        } else if (getYear()  >= 1955) {
            return "Change Era";
        } else if (getYear()  >= 1941) {
            return "Golden Era";
        } else {
            return "Pre-Golden Era";
        }
    }

    @Override
    public boolean wasReleasedAfter(Media other) {
        return getYear() > other.getYear();
    }

    @Override
    public boolean wasReleasedBeforeOrInSameYear(Media other) {
        return getYear() <= other.getYear();
    }


}
