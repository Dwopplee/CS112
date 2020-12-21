import java.util.Scanner;

public class Problem1 {

    public static void main (String[] args) {
        Scanner sysIn = new Scanner(System.in);
        StringCollector collection = new StringCollector();

        System.out.println("Enter a line of text");
        String input = sysIn.nextLine();

        while (input.compareTo("exit") != 0) {
            collection.add(input);
            System.out.println("Enter a line of text");
            input = sysIn.nextLine();
        }

        collection.printCollection();
    }

}
