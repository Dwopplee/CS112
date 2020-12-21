public class CarInfoVIN implements Comparable<CarInfoVIN> {

    private String make;
    private String model;
    private int year;
    private String vin;

    public CarInfoVIN(String info) {
        String[] carInfo = info.split("\t");
        make = carInfo[0];
        model = carInfo[1];
        year = Integer.parseInt(carInfo[2]);
        vin = carInfo[3];
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

    public String getVIN() {
        return vin;
    }

    public String toString() {
        return String.format("%15s%25s%5d%18s", make, model, year, vin);
    }

    @Override
    public int compareTo(CarInfoVIN o) {
        if (make.compareToIgnoreCase(o.getMake()) != 0) {
            return make.compareToIgnoreCase(o.getMake());
        } else {
            if (year - o.getYear() != 0){
                return year - o.getYear();
            } else {
                return vin.compareToIgnoreCase(o.getVIN());
            }
        }
    }

}
