import java.util.Scanner;

public class Question2 {

    public static void main (String[] args) {
        Scanner sysIn = new Scanner(System.in);

        String input;
        int number;
        int sum = 0;

        do {
            System.out.println("Enter a integer");
            input = sysIn.nextLine();

            try {
                number = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                input = input.replaceAll("\\D", "");

                if (input.length() == 0) {
                    System.out.println("There were no digits in that input.");
                    break;
                }

                number = Integer.parseInt(input);
                System.out.println("Well, that's not a number but here's what I extracted: " + number);
            }

            sum += number;
            System.out.println("Current sum: " + sum);

        } while (number != 0);

        System.out.println("Final sum: " + sum);
    }

}
