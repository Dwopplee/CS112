import java.util.ArrayList;

public class CustomerCollector extends ArrayList<Customer> {

    ArrayList<Customer> collection = new ArrayList<>(0);

    public void add (int id) {
        for (int i = collection.size(); i < id; i++) {
            collection.add(new Customer(i + 1));
        }
    }

    public Customer get (int id) {
        return collection.get(id - 1);
    }

    public void printCollection() {
        for (Customer customer : collection) {
            System.out.println(customer);
        }
    }

}
