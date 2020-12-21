import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Employee {

    private String id;
    private String first;
    private String last;
    private String email;

    public Employee(String info) {
        String[] EmployeeInfo = info.split("\t");
        id = EmployeeInfo[0];
        first = EmployeeInfo[1];
        last = EmployeeInfo[2];
        email = EmployeeInfo[3];
    }

    public String getId() {
        return id;
    }

    public String toString() {
        return String.format("%s -> %s %s %s", id, first, last, email);
    }

    public static Map<String, Employee> load() {
        HashMap<String, Employee> employeeMap = new HashMap<String, Employee>(0);

        try {
            Scanner fileIn = new Scanner (new File("employees.txt"));

            fileIn.nextLine();

            while (fileIn.hasNextLine()) {
                Employee employee = new Employee(fileIn.nextLine());

                employeeMap.put(employee.getId(), employee);
            }

            fileIn.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        return employeeMap;
    }

}
