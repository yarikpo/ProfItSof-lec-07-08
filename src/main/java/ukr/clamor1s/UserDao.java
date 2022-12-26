package ukr.clamor1s;

import java.util.Collections;
import java.util.List;

public class UserDao {

    private static List<User> users = List.of(
            new User("alan13", "Alan", "123"),
            new User("amerser", "Alex", "qwerty"),
            new User("travoltaJ", "John", "222")
    );

    public static List<User> getUsers() {
        return UserDao.users;
    }

    public static List<User> getAll() {

        return Collections.unmodifiableList(UserDao.getUsers()
                .stream()
                .map(u -> u.setReturnPassword(""))
                .toList());
    }

    public static User getByLogin(String login) {

        return UserDao.getUsers()
                .stream()
                .filter(user -> user.getLogin().equals(login))
                .findAny()
                .orElse(null);
    }

}
