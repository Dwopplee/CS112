import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Question4 {

    public static void main (String[] args) {
        Scanner sysIn = new Scanner(System.in);

        System.out.println("Enter a filename");
        String filename =  sysIn.nextLine();

        try {
            FileInputStream fIStream = new FileInputStream(filename);
            DataInputStream input = new DataInputStream(fIStream);

            ArrayList<Integer> array = new ArrayList<Integer>(0);

            boolean eof = false;
            while (!eof) {
                try {
                    array.add(input.readInt());
                } catch (EOFException e) {
                    eof = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            int min = array.get(0);
            int max = array.get(0);

            for (int i = 0; i < array.size(); i++) {
                if (min > array.get(i)) {
                    min = array.get(i);
                } else if (max < array.get(i)) {
                    max = array.get(i);
                }
            }

            System.out.printf("Found %d integers.%nMax: %d%nMin: %d%n", array.size(), max, min);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }

}
