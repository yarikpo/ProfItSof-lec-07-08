package ukr.clamor1s;

public class User {

    private String login;
    private String name;
    private String password;

    public User() {}

    public User(String login, String name, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User setReturnPassword(String password) {
        return new User(this.getLogin(), this.getName(), "");
    }
}
