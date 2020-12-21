public class User implements Comparable<User> {

    private String username;
    private String password;

    public User(String info) {
        String[] userInfo = info.split("\\s+");
        username = userInfo[0];
        password = userInfo[1];
    }

    public User (String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    // Highly secure
    public String getPassword() {
        return password;
    }

    @Override
    public int compareTo(User user) {
        String pass2 = user.getPassword();
        if (password.length() != pass2.length()) {
            return password.length() - pass2.length();
        } else if (password.compareToIgnoreCase(pass2) != 0){
            return password.compareToIgnoreCase(pass2);
        } else {
            return username.compareToIgnoreCase(user.getUsername());
        }
    }

    @Override
    public String toString() {
        return String.format("%20s%20s", password, username);
    }
}
