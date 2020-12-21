import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class StackUtils {

    public static Stack<Character> buildStack (File f) {
        Stack<Character> stack = new Stack<Character>();
        try {
            Scanner fileIn = new Scanner(f);

            while (fileIn.hasNextLine()) {
                String line = fileIn.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    char current = line.charAt(i);
                    if (current == '{' || current == '}') {
                        stack.push(current);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return stack;
    }

    public static int reduce (File f) {
        Stack<Character> stack = buildStack(f);

        // No idea what the appropriate check is, so I'm using this
        boolean first = true;
        int count = 0;

        while (!stack.empty()) {
            if (stack.pop() == '}') {
                count--;
            } else if (!first){
                count++;
            }
            first = false;
        }

        return count;
    }

}
