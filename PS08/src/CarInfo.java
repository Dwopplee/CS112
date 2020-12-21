public class CarInfo implements Comparable<CarInfo> {

    private String make;
    private String model;
    private int year;

    public CarInfo(String info) {
        String[] carInfo = info.split("\t");
        make = carInfo[0];
        model = carInfo[1];
        year = Integer.parseInt(carInfo[2]);
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        return String.format("%15s%25s%5d", make, model, year);
    }

    @Override
    public int compareTo(CarInfo o) {
        if (make.compareToIgnoreCase(o.getMake()) != 0) {
            return make.compareToIgnoreCase(o.getMake());
        } else {
            if (model.compareToIgnoreCase(o.getModel()) != 0) {
                return model.compareToIgnoreCase(o.getModel());
            } else {
                return year - o.getYear();
            }
        }
    }
}
