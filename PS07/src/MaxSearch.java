import java.util.Scanner;
import java.util.InputMismatchException;

public class MaxSearch {

    private static Scanner sysIn = new Scanner (System.in);

    public static void main (String[] args) {
        System.out.println("Enter several numbers. Enter a non-integer to end.");
        checkInt();
    }

    private static void checkInt() {
        try {
            int input = sysIn.nextInt();
            checkInt(input, input);
        } catch (InputMismatchException e) {
            System.out.println("No integers were entered.");
        }
    }

    private static void checkInt(int last, int max) {
        if (last > max) {
            max = last;
        }
        try {
            checkInt(sysIn.nextInt(), max);
        } catch (InputMismatchException e) {
            System.out.println("Greatest number in that sequence is " + max);
        }
    }

}
