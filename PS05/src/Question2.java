import java.io.*;
import java.util.Scanner;

public class Question2 {

    public static void main (String[] args) {
        try {
            Scanner sysIn = new Scanner(System.in);

            FileInputStream fIStream = new FileInputStream("names.dat");
            DataInputStream input = new DataInputStream(fIStream);

            System.out.println("Enter a length");
            int sysInLength = sysIn.nextInt();
            int count = 0;

            System.out.printf("Names of length %d%n", sysInLength);

            boolean eof = false;
            while (!eof) {
                try {
                    int length = input.readInt();

                    StringBuilder name = new StringBuilder(0);
                    for (int i = 0; i < length; i++) {
                        name.append(input.readChar());
                    }

                    if (length == sysInLength) {
                        System.out.println(name);
                        count++;
                    }

                } catch (EOFException e) {
                    eof = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.printf("%d results%n", count);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

}
