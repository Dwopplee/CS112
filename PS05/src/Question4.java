import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Question4 {

    public static void main (String[] args) {
        try {
            Scanner sysIn = new Scanner(System.in);

            FileInputStream fIStream = new FileInputStream("accounts-with-names.dat");
            DataInputStream input = new DataInputStream(fIStream);

            System.out.println("Enter a balance");
            double min = sysIn.nextDouble();
            int count = 0;

            System.out.printf("Accounts with a balance of at least $%.2f (sorted by balance)%n", min);
            System.out.printf("%20s%20s%10s%10s%n", "Name", "Account Number", "Balance", "Cash Back");

            ArrayList<Person> people = new ArrayList<Person>(0);

            boolean eof = false;
            while (!eof) {
                try {
                    int length = input.readInt();
                    StringBuilder name = new StringBuilder(0);
                    for (int i = 0; i < length; i++) {
                        name.append(input.readChar());
                    }

                    long accountNumber = input.readLong();

                    double balance = input.readDouble();

                    boolean cashBack = input.readBoolean();

                    if (balance > min) {
                        people.add(new Person(name.toString(), accountNumber, balance, cashBack));
                    }
                } catch (EOFException e) {
                    eof = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            Collections.sort(people);

            for (Person current : people) {
                System.out.println(current);
            }

            System.out.printf("%d results%n", people.size());
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

}
