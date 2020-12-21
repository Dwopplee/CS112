public class SmartPhone extends Phone {

    private String email = "None";

    public SmartPhone() {
        super();
    }

    public SmartPhone(String name, String num) {
        this(name, num, "None");
    }

    public SmartPhone(String name, String num, String email) {
        long number = Long.parseLong(num);
        this.number = number;
        this.name = name;
        this.email = email;
    }

    public boolean hasPhoneNumber() {
        if (number != -1) {
            return true;
        } else {
            return false;
        }
    }

    public int getAreaCode() {
        String num = String.valueOf(number);

        return Integer.parseInt(num.substring(0, 3));
    }

    public int getPrefix() {
        String num = String.valueOf(number);

        return Integer.parseInt(num.substring(3, 6));
    }

    public int getLineNumber() {
        String num = String.valueOf(number);

        return Integer.parseInt(num.substring(6));
    }

    public String getTeleponeNeighbor() {
        if (hasPhoneNumber()) {
            SmartPhone neighbor = new SmartPhone("neighbor", String.valueOf(number + 1));
            return String.format("(%3d) %03d-%04d", neighbor.getAreaCode(), neighbor.getPrefix(),
                    neighbor.getLineNumber());
        } else {
            return "Cannot calculate phone number neighbor";
        }
    }

    @Override
    public String toString() {
        if (number != -1) {
            return "Name: " + name + "\n" +
                    "Phone: " + number + "\n" +
                    "Email: " + email + "\n";
        } else {
            return "Name: " + name + "\n" +
                    "Phone: Not set\n" +
                    "Email: " + email + "\n";
        }

    }
}
