import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem1 {

    public static ArrayList<CarInfo> loadCars () {
        ArrayList<CarInfo> cars = new ArrayList<CarInfo>(0);

        try {
            Scanner fileIn = new Scanner (new File("cars.txt"));

            fileIn.nextLine();

            while (fileIn.hasNextLine()) {
                cars.add(new CarInfo(fileIn.nextLine()));
            }

            fileIn.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        return cars;
    }

    public static void main (String[] args) {
        ArrayList<CarInfo> data = loadCars();

        for (CarInfo car : data) {
            System.out.println(car);
        }
    }

}
