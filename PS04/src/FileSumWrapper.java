import java.rmi.UnexpectedException;
import java.util.InputMismatchException;

public class FileSumWrapper {

    public static void handle (String filename, int lowerBound) {
        try {
            int sum = FileSum.read(filename, lowerBound);
            System.out.printf("Sum of all numbers in %s is %d%n", filename, sum);
        } catch (UnexpectedException e) {
            System.out.println("CS112 error: Found no numbers above " + lowerBound);
        } catch (InputMismatchException e) {
            System.out.println("CS112 error: Was reading integers but found something else");
        } catch (Exception e) {
            System.out.println("CS112 error: Couldn't open " + filename);
        }
    }

}
