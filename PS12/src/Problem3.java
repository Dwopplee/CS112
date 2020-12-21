import java.util.Scanner;

public class Problem3 {

    public static void main (String[] args) {
        Scanner sysIn = new Scanner(System.in);

        int output;

        do {
            System.out.println("Enter an expression in prefix form (operator comes first)");

            String expression = sysIn.nextLine();
            output = QueueUtils.eval(QueueUtils.build(expression));

            System.out.println(output);
        } while (output != 0);

        System.out.println("Exiting");
    }

}
