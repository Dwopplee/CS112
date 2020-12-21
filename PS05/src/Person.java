import java.io.*;

public class Person implements Comparable<Person>, Serializable {
    private String name;
    private long number;
    private double balance;
    private String cashBack;

    public Person (String name, long number, double balance, boolean cashBack) {
        this.name = name;
        this.number = number;
        this.balance = balance;
        if (cashBack) {
            this.cashBack = "Yes";
        } else {
            this.cashBack = "No";
        }
    }

    public double getBalance() {
        return balance;
    }

    public void save() {
        try {
            String filename = number + ".dat";
            FileOutputStream oStream = new FileOutputStream(filename);
            ObjectOutputStream oOStream = new ObjectOutputStream(oStream);
            oOStream.writeObject(this);
            oOStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int compareTo(Person currentPerson) {
        return (int) (currentPerson.getBalance() - balance);
    }

    @Override
    public String toString() {
        return String.format("%20s%20d%10.2f%10s", name, number, balance, cashBack);
    }

}
