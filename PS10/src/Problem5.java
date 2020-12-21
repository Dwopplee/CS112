import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem5 {

    public static void main (String[] args) {
        Scanner sysIn = new Scanner(System.in);

        System.out.println("Enter a filename");

        String filename = sysIn.nextLine();

        CustomerCollector collector = new CustomerCollector();

        try {
            Scanner fileIn = new Scanner (new File(filename));

            fileIn.nextLine();

            while (fileIn.hasNextLine()) {
                String[] info = fileIn.nextLine().split("\t\\$");
                int id = Integer.parseInt(info[0]);
                double balance = Double.parseDouble(info[1]);

                collector.add(id);
                collector.get(id).add(balance);
            }

            fileIn.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        collector.printCollection();
    }

}
