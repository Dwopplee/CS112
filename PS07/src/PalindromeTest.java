import java.util.Scanner;

public class PalindromeTest {

    public static void main (String[] args) {
        Scanner sysIn = new Scanner(System.in);

        System.out.println("Enter a String");

        test(sysIn.nextLine());
    }

    private static void test(String input) {
        if (test(input.toLowerCase(), 0)) {
            System.out.println("That is a palindrome");
        } else {
            System.out.println("That is NOT a palindrome");
        }
    }

    private static boolean test(String input, int iteration) {
        if (((input.length() / 2) + (input.length() % 2)) > iteration) {
            return test(input, ++iteration) &&
                    input.charAt(iteration) == input.charAt(input.length() - iteration - 1);
        } else {
            return true;
        }
    }



}
