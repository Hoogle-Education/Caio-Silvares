import java.util.ArrayList;
import java.util.List;

public class Main {

    static void printUsersFrom(App app) {
        var users = app.getUsers();
        for(var user : users) {
            System.out.println(user);
        }
        System.out.println("----------------------");
    }

    public static void main(String[] args) {

        User user1 = new User("user1", "user1@gmail.com", "p123", "ios");
        User user2 = new User("user2", null, "p123", "ios");
        User user3 = new User("user3", null, "p123", "android");
        User user4 = new User("user4", "user4@gmail.com", "p123", "android");
        User user5 = new User("user5", "user5@gmail.com", "p123", "ios");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        users.stream().forEach(u -> System.out.println(u));
        System.out.println("------------------------");
        var list = users.stream().filter(u -> u.getEmail() != null).toList();
        list.forEach(e -> System.out.println(e));
        System.out.println("------------------------");
        var profiles = list
                .stream()
                .map(u -> new Profile(u.getUsername(), u.getEmail()))
                .toList();

        profiles.forEach(p -> System.out.println(p));
        System.out.println("------------------------");
    }

    static boolean isAndroidUser(User user) {
        return user.getDeviceType().equals("andoird");
    }
}

// INTERFACES FUNCIONAL

// Predicate (T -> boolean)
// > validações
// Predicate<Integer> checkIfIsGreaterThanTwo = (x) -> x > 2

// Consumer (T -> void)
// reproduzir alguma ação baseada no objeto
// Consumer<Products> showProduct = (p) -> System.out.println(p)

// Function (T -> R)
// Function<String, Integer> conversor = (w) -> w.size();
