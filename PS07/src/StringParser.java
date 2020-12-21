import java.util.Scanner;

public class StringParser {

    public StringParser (String input) {
        System.out.println("Here is that String in reverse");
        iterate(input);
        System.out.println();
    }

    public static void main (String[] args) {
        Scanner sysIn = new Scanner(System.in);

        System.out.println("Enter a String");
        StringParser p2 = new StringParser(sysIn.nextLine());
    }

    private void iterate(String input) {
        if (input.length() > 1) {
            iterate(input.substring(1));
        }
        System.out.print(input.charAt(0));
    }

}
