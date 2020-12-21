import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Question5 {

    public static void main (String[] args) {
        Scanner sysIn = new Scanner (System.in);

        System.out.println("Enter a filename");
        String filename = sysIn.nextLine();

        try {
            FileInputStream fIStream = new FileInputStream(filename);
            DataInputStream input = new DataInputStream(fIStream);

            boolean eof = false;
            while (!eof) {
                try {
                    validate(input.readLong());
                } catch (EOFException e) {
                    eof = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static void validate(long number) {
        boolean second = false;
        ArrayList<Integer> digits = new ArrayList<Integer>(0);
        int sum = 0;

        for (int i = 0; number > 0; i++) {
            digits.add((int) (number % 10));
            number /= 10;
            if (i % 2 == 0) {
                sum += digits.get(i);
            } else {
                if (digits.get(i) * 2 > 9) {
                    sum += digits.get(i) * 2 - 9;
                } else {
                    sum += digits.get(i) * 2;
                }
            }
        }

        System.out.print("Credit card number: ");

        for (int i = 1; i <= digits.size(); i++) {
            System.out.print(digits.get(digits.size() - i));
            if (i % 4 == 0 && i != digits.size()) {
                System.out.print(" ");
            }
        }

        System.out.println("\nChecksum: " + sum);
        if (sum % 10 == 0) {
            System.out.println("Card status: VALID");
        } else {
            System.out.println("Card status: INVALID");
        }
    }

}
