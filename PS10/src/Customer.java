public class Customer {

    private int id;
    private Double balance;
    private double min;
    private double max;

    public Customer (int id) {
        this.id = id;
    }

    public void add (double next) {
        if (balance == null) {
            min = next;
            max = next;
        } else {
            if (min > next) {
                min = next;
            } else if (max < next) {
                max = next;
            }
        }
        balance = next;

    }

    public String toString() {
        return String.format("Customer %d: Last balance: $%.2f High balance: $%.2f " +
                "Low balance: $%.2f", id, balance, max, min);
    }

}
