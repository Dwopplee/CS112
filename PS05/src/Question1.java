import java.io.*;
import java.util.Scanner;

public class Question1 {

    public static void main (String[] args) {
        try {
            Scanner sysIn = new Scanner(System.in);

            FileInputStream fIStream = new FileInputStream("accounts.dat");
            DataInputStream input = new DataInputStream(fIStream);

            System.out.println("Enter a balance");
            double min = sysIn.nextDouble();
            int count = 0;

            System.out.printf("Accounts with a balance of at least $%.2f%n", min);
            System.out.printf("%20s%10s%12s%n", "Card Number", "Balance", "Cash Back?");

            boolean eof = false;
            while (!eof) {
                try {
                    long cardNumber = input.readLong();
                    double balance = input.readDouble();
                    String cashBack;
                    if (input.readBoolean()) {
                        cashBack = "Yes";
                    } else {
                        cashBack = "No";
                    }

                    if (balance > min) {
                        System.out.printf("%20d%10.2f%12s%n", cardNumber, balance, cashBack);
                        count++;
                    }
                } catch (EOFException e) {
                    eof = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.printf("%34d results%n", count);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

}
