import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem5 {

    public static ArrayList<CarInfoVIN> loadCars () {
        ArrayList<CarInfoVIN> cars = new ArrayList<CarInfoVIN>(0);

        System.out.println("Enter filename");

        Scanner sysIn = new Scanner(System.in);
        String filename = sysIn.nextLine();

        try {

            Scanner fileIn = new Scanner (new File(filename));

            fileIn.nextLine();

            while (fileIn.hasNextLine()) {
                cars.add(new CarInfoVIN(fileIn.nextLine()));
            }

            fileIn.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        return cars;
    }

    public static void main (String[] args) {
        ArrayList<CarInfoVIN> data = loadCars();

        QuickSort.quickSort(data);

        System.out.println("Oldest cars by make");

        String lastMake = "";
        int results = 0;

        for (int i = 0; i < data.size(); i++) {
            if (!lastMake.equalsIgnoreCase(data.get(i).getMake())) {
                lastMake = data.get(i).getMake();
                System.out.println(data.get(i));
                results++;
            }
        }

        System.out.println(results + " result(s)");
    }

}
