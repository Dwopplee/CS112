public class HashGen {

    public static int makeHash (String input) {
        int hash = 0;

        for (int i = 0; i < input.length(); i++) {
            hash += getCharHash(input.charAt(i), i + 1);
        }

        return hash;
    }

    private static int getCharHash (char input, int pos) {
        int code = input;

        if (code >= 65 && code <= 90) {
            code += 32;
        }

        if (code >= 97 && code <= 122) {
            if (code == 97) {
                return 100;
            } else if (code == 101) {
                return 200;
            } else if (code == 105) {
                return 300;
            } else if (code == 111) {
                return 400;
            } else if (code == 117) {
                return 500;
            } else {
                code -= 96;
                return code * pos;
            }
        } else {
            return 0;
        }
    }

}
