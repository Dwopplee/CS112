public class Cipher {

    private String plainText;
    private int key;
    private String cipherText;

    public Cipher (String plainText, int key) throws UselessKeyException, EmptyPlainText {
        if (key % 26 == 0) {
            throw new UselessKeyException(key);
        }

        if (plainText.length() == 0) {
            throw new EmptyPlainText();
        }

        this.key = key;
        this.plainText = plainText;

        encrypt();
    }

    private void encrypt() {
        int tempKey = key % 26;
        StringBuilder txt = new StringBuilder(0);

        for (int i = 0; i < plainText.length(); i++){
            char c = plainText.charAt(i);

            if (c <= 90 && c >= 65) {
                c = (char) ((c - 65 + tempKey) % 26 + 65);
            } else if (c <= 122 && c >= 97) {
                c = (char) ((c - 97 + tempKey) % 26 + 97);
            } else {
                c = (char) ((c + tempKey) % 127);
            }

            txt.append(c);
        }

        cipherText = txt.toString();
    }

    public String getPlainText () {
        return plainText;
    }

    public int getKey () {
        return key;
    }

    public String getCipherText () {
        return cipherText;
    }

}

class UselessKeyException extends Exception {
    private int uselessKey;

    public UselessKeyException (int uselessKey) {
        super("Error: Key is divisible by 26. That's a bad key!");
        this.uselessKey = uselessKey;
    }

    public int getUselessKey () {
        return uselessKey;
    }

}

class EmptyPlainText extends Exception {

    public EmptyPlainText () {
        super("Error: Nothing to encrypt!");
    }

}
