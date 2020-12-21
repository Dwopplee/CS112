import java.util.Scanner;

public class Problem4
{
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Enter a phone number");
    String phone = keyboard.nextLine();

    Telephone t = new Telephone(phone);
    for (String result : t.getPossibilities()) {
      System.out.println(result);
    }
  }
}
