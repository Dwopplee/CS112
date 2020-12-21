public class SumToMax {

    private int sum = 0;
    private int max;

    public SumToMax(int max) {
        if (max >= 1) {
            this.max = max;
            iterate(max);
        } else {
            System.out.println("Maximum must be positive.");
        }
    }

    private void iterate(int last) {
        sum += last;
        if (last > 1) {
            iterate(--last);
        } else {
            System.out.println("The sum of number from 1 to " + max + " is " + sum);
        }
    }

}
