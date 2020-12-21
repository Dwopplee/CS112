public abstract class Media {
    private String name;
    private int year;
    private String genre;

    public Media(String n, int y, String g) {
        name = n;
        year = y;
        genre = g;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String toString() {
        return String.format("%5d %-55s %-15s", year, name, genre);
    }

    //if the media was released on or after the year 2000, return New Millennium Era
    //if the media was released on or after the year 1977, return Modern Era
    //if the media was released on or after the year 1955, return Change Era
    //if the media was released on or after the year 1941, return Golden Era
    //in any other situation, return Pre-Golden Era
    public abstract String getEra();

    //return true if this media has a greater release year than the other's
    public abstract boolean wasReleasedAfter(Media other);

    //return true if this media was a lesser or equal release yearn than the other's
    public abstract boolean wasReleasedBeforeOrInSameYear(Media other);
}
