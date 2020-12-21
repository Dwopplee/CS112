import java.util.Scanner;

public class Problem4 {

    public static void main (String[] args) {
        Scanner sysIn = new Scanner (System.in);
        HashCollector collector = new HashCollector();

        System.out.println("Enter ten words");
        for (int i = 0; i < 10; i++) {
            collector.add(sysIn.nextLine());
        }

        collector.printCollection();
    }

}
