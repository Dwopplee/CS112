import java.util.ArrayList;
import java.util.Arrays;

public class Telephone {

    private String phone;
    private int i;

    public Telephone(String phone) {
        this.phone = phone;
    }

    public ArrayList<String> getPossibilities() {
        ArrayList<String> output = getPossibilities(phone);
        return output;
    }

    private ArrayList<String> getPossibilities(String input) {
        if (input.length() > 1) {
            char first = input.charAt(0);
            String remainder = input.substring(1);

            char[] chars = getChars(first);

            ArrayList<String> possibilities = getPossibilities(remainder);
            ArrayList<String> strings = appendEach(chars, possibilities);

            return strings;
        } else {
            ArrayList<String> strings = new ArrayList<String>(0);
            strings.addAll(getStrings(input.charAt(0)));
            return strings;
        }
    }

    // Makeshift for-loop for looping over getChars()
    private ArrayList<String> appendEach(char[] firsts, ArrayList<String> ends) {
        ArrayList<String> set = appendEach(firsts[0], ends);
        if (firsts.length > 1) {
            firsts = Arrays.copyOfRange(firsts, 1, firsts.length);
            set.addAll(appendEach(firsts, ends));
        }
        return set;
    }

    private ArrayList<String> appendEach(char first, ArrayList<String> ends) {
        if (ends.isEmpty()) {
            ArrayList<String> fulls = new ArrayList<String>(0);
            fulls.add(Character.toString(first));

            return new ArrayList<String>(0);
        } else {
            String full = first + ends.get(0);

            ArrayList<String> newEnds = new ArrayList<String>(0);
            newEnds.addAll(ends);
            newEnds.remove(0);

            ArrayList<String> fulls = appendEach(first, newEnds);
            fulls.add(0, full);

            return fulls;
        }
    }

    private char[] getChars(char input) {
        if (input <= 54 && input >= 50) {
            // 2 - 6, excluding 7
            char c1 = (char) ((input - 50) * 3 + 65);
            char c2 = (char) ((input - 50) * 3 + 66);
            char c3 = (char) ((input - 50) * 3 + 67);

            return new char[]{c1, c2, c3};
        } else if (input == 56) {
            //8
            return new char[]{'T', 'U', 'V'};
        } else if (input == 55) {
            // 7
            return new char[]{'P', 'Q', 'R', 'S'};
        } else if (input == 57) {
            // 9
            return new char[]{'W', 'X', 'Y', 'Z'};
        } else {
            return new char[]{input};
        }
    }

    private ArrayList<String> getStrings(char input) {
        ArrayList<String> strings = new ArrayList<String>(0);

        if (input <= 54 && input >= 50) {
            // 2 - 8
            String c1 = Character.toString((char)((input - 50) * 3 + 65));
            String c2 = Character.toString((char)((input - 50) * 3 + 66));
            String c3 = Character.toString((char)((input - 50) * 3 + 67));

            strings.add(c1);
            strings.add(c2);
            strings.add(c3);
        } else if (input == 56) {
            // 8
            strings.add("T");
            strings.add("U");
            strings.add("V");
        } else if (input == 55) {
            // 7
            strings.add("P");
            strings.add("Q");
            strings.add("R");
            strings.add("S");
        } else if (input == 57) {
            // 9
            strings.add("W");
            strings.add("X");
            strings.add("Y");
            strings.add("Z");
        } else {
            strings.add(Character.toString(input));
        }
        return strings;
    }

}
