import java.util.Scanner;

public class Problem0 {

    public static void main (String[] args) {
        Scanner sysIn = new Scanner(System.in);

        System.out.println("Enter any text");
        String input = sysIn.nextLine();

        System.out.println("The CS112 hashcode for that string is " + HashGen.makeHash(input));
    }

}
