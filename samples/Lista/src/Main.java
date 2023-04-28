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

        App uber = new App("uber");
        uber.setAndroidVersion(true);
        uber.setIosVersion(true);
        uber.setScore(4.2);

        List<User> myUsers = new ArrayList<>();
        myUsers.add(user3);
        myUsers.add(user4);
        myUsers.add(user5);

        uber.addUser(user1);
        uber.addUser(user2);
        uber.addUsers(myUsers);
        printUsersFrom(uber);

        uber.removeUser(user3);
        printUsersFrom(uber);
        myUsers.stream().filter(Main::isAndroidUser).toList();
        var allUsersHasEmail = myUsers.stream().allMatch(user -> user.getEmail() != null);
    }

    static boolean isAndroidUser(User user) {
        return user.getDeviceType().equals("andoird");
    }
}
