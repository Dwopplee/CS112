import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem3 {

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

        System.out.println("What car make are you looking for?");
        Scanner sysIn = new Scanner(System.in);
        String make = sysIn.nextLine();

        for (int i = data.size() - 1; i >= 0; i--) {
            if (!data.get(i).getMake().equals(make)) {
                data.remove(i);
            }
        }

        QuickSort.quickSort(data);

        for (CarInfo car : data) {
            System.out.println(car);
        }
    }

}
