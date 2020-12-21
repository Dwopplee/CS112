public class Employee {

    private String name;
    private int year;
    private String department;
    private String job;

    public Employee(String nm, int yr, String dep, String jb) {
        name = nm;
        year = yr;
        department = dep;
        job = jb;
    }

    public Employee(String nm, int yr) {
        name = nm;
        year = yr;
        department = "(not set)";
        job = "(not set)";
    }

    public Employee() {
        name = "(not set)";
        year = 0;
        department = "(not set)";
        job = "(not set)";
    }

    public String getName() {
        return name;
    }

    public int getIdNumber() {
        return year;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return job;
    }



}
