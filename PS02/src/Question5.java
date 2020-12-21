import java.util.Scanner;

public class Question5 {

    public static void main (String[] args) {
        Scanner sysIn = new Scanner(System.in);

        System.out.println("New number creation tool");

        System.out.println("Enter name");
        String name = sysIn.nextLine();

        System.out.println("Enter phone number");
        String number = sysIn.nextLine();

        System.out.println("Enter email");
        String email = sysIn.nextLine();

        SmartPhone userPhone = new SmartPhone(name, number, email);

        System.out.print(userPhone);

        System.out.println("Telephone neighbor: " + userPhone.getTeleponeNeighbor());
    }

}
