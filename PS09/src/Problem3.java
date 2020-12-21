import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem3 {

    public static ArrayList<User> loadUsers () {
        ArrayList<User> users = new ArrayList<User>(0);

        try {
            Scanner fileIn = new Scanner (new File("user-database.txt"));

            fileIn.nextLine();

            while (fileIn.hasNextLine()) {
                users.add(new User(fileIn.nextLine()));
            }

            fileIn.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        return users;
    }

    public static void main (String[] args) {
        ArrayList<User> data = loadUsers();

        Scanner sysIn = new Scanner(System.in);

        System.out.println("Enter a starting point and ending point");

        int start = sysIn.nextInt();
        int end = sysIn.nextInt();

        QuickSort.quickSort(data);

        for (int i = start; i < end; i++) {
            System.out.println(data.get(i));
        }
    }

}
