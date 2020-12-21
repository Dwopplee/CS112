import java.io.File;
import java.rmi.UnexpectedException;
import java.util.Scanner;

public class FileSum {

    public static int read(String filename, int lowerBound) throws Exception {
        Scanner inputFile = new Scanner(new File(filename));

        int acc = 0;
        boolean atLeastOneFound = false;
        while (inputFile.hasNext()) {
            int data = inputFile.nextInt();
            if (data >= lowerBound) {
                acc += data;
                atLeastOneFound = true;
            }
        }

        if (!atLeastOneFound) {
            throw new UnexpectedException("");
        }

        return acc;
    }

}
