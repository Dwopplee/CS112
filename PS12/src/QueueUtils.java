import java.util.LinkedList;
import java.util.Queue;

public class QueueUtils {

    public static Queue<String> build (String line) {
        String[] elements = line.split("\\s+");

        LinkedList<String> queue = new LinkedList<>();

        for (int i = 0; i < elements.length; i++) {
            queue.add(elements[i]);
        }

        return queue;
    }

    public static int eval (Queue<String> s) {
        String element = s.poll();

        if (isOperator(element)) {
            return eval(s, element);
        } else {
            return Integer.parseInt(element);
        }
    }

    private static int eval (Queue<String> s, String operator) {
        String element = s.poll();

        int int1;

        if (isOperator(element)) {
            int1 = eval(s, element);
        } else {
            int1 = Integer.parseInt(element);
        }
        String element2 = s.poll();

        if (isOperator(element2)) {
            return operate(int1, eval(s, element2), operator);
        } else {
            int int2 = Integer.parseInt(element2);

            return operate(int1, int2, operator);
        }
    }

    private static boolean isOperator (String element) {
        return (element.equals("+") || element.equals("-") || element.equals("*")
                || element.equals("/"));
    }

    private static int operate (int int1, int int2, String operator) {
        switch(operator) {
            case("+"):
                return int1 + int2;
            case("-"):
                return int1 - int2;
            case("*"):
                return int1 * int2;
            case("/"):
                return int1 / int2;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }
    }

}
