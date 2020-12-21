import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem4 {

    public static ArrayList<CarInfoVIN> loadCars () {
        ArrayList<CarInfoVIN> cars = new ArrayList<CarInfoVIN>(0);

        try {
            Scanner fileIn = new Scanner (new File("car-list.txt"));

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

        System.out.println("What car make are you looking for?");
        Scanner sysIn = new Scanner(System.in);
        String make = sysIn.nextLine();

        for (int i = data.size() - 1; i >= 0; i--) {
            if (!data.get(i).getMake().equals(make)) {
                data.remove(i);
            }
        }

        int minYear = data.get(0).getYear();
        int maxYear = data.get(0).getYear();

        ArrayList<Integer> minIndices = new ArrayList<Integer>(0);
        ArrayList<Integer> maxIndices = new ArrayList<Integer>(0);

        for (int i = 0; i < data.size(); i++) {
            int year = data.get(i).getYear();
            if (year < minYear) {
                minIndices.clear();
                minIndices.add(i);
                minYear = year;
            } else if (year == minYear) {
                minIndices.add(i);
            }

            if (year > maxYear) {
                maxIndices.clear();
                maxIndices.add(i);
                maxYear = year;
            } else if(year == maxYear) {
                maxIndices.add(i);
            }
        }

        ArrayList<CarInfoVIN> mins = new ArrayList<CarInfoVIN>(0);
        for (int i = 0; i < minIndices.size(); i++) {
            mins.add(data.get(minIndices.get(i)));
        }

        ArrayList<CarInfoVIN> maxs = new ArrayList<CarInfoVIN>(0);
        for (int i = 0; i < maxIndices.size(); i++) {
            maxs.add(data.get(maxIndices.get(i)));
        }

        VINSort.quickSort(mins);
        VINSort.quickSort(maxs);

        System.out.println("Oldest " + make);
        System.out.println(mins.get(0));

        System.out.println("Newest " + make);
        System.out.println(maxs.get(maxs.size() - 1));
    }

    private static class VINSort {
        private static int partition(ArrayList<CarInfoVIN> data, int start, int end) {
            int mid = (start + end) / 2;
            String pivot = data.get(mid).getVIN();
            Collections.swap(data, start, mid);
            int next = start;

            for (int i = start + 1; i <= end; i++) {
                if (data.get(i).getVIN().compareTo(data.get(start).getVIN()) < 0) {
                    next++;
                    Collections.swap(data, i, next);
                }
            }

            Collections.swap(data, start, next);
            return next;
        }

        private static void quickSort(ArrayList<CarInfoVIN> data, int start, int end) {
            if (start < end) {
                int splitIndex = partition(data, start, end);
                quickSort(data, start, splitIndex - 1);
                quickSort(data, splitIndex + 1, end);
            }
        }

        public static void quickSort(ArrayList<CarInfoVIN> data) {
            quickSort(data, 0, data.size() - 1);
        }
    }

}
