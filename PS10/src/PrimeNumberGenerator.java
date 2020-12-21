import java.util.ArrayList;
import java.util.List;

public class PrimeNumberGenerator {

    public static List<Long> generate(int quantity) {
        int tempQuant = quantity < 6 ? 6 : quantity;

        int upperEstimate = (int)(tempQuant * Math.log(tempQuant) + tempQuant *
                Math.log(Math.log(tempQuant)));

        ArrayList<Long> primes = sieveOfEratosthenes(upperEstimate);

        return primes.subList(0, quantity);
    }

    // Doesn't work with longs but that seems excessive. Why even?
    // Would half expect it to break under the load of calculating that much
    private static ArrayList<Long> sieveOfEratosthenes(int limit) {
        boolean[] notPrime = new boolean[limit + 1];

        for (int i = 2; i <= (int)(Math.sqrt(limit)); i++) {
            if (!notPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    notPrime[j] = true;
                }
            }
        }

        ArrayList<Long> primes = new ArrayList<Long>(0);

        for (int i = 2; i < limit; i++) {
            if (!notPrime[i]) {
                primes.add((long)i);
            }
        }

        return primes;
    }

}
