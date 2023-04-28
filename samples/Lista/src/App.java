import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class App {

    private String name;
    private boolean androidVersion;
    private boolean iosVersion;
    private double score;
    private List<User> users = new ArrayList<>();

    public App(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean hasAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(boolean androidVersion) {
        this.androidVersion = androidVersion;
    }

    public boolean hasIosVersion() {
        return iosVersion;
    }

    public void setIosVersion(boolean iosVersion) {
        this.iosVersion = iosVersion;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public void addUsers(Collection<? extends  User> users){
        this.users.addAll(users);
    }

    public void removeUser(User user) {
        this.users.remove(user);
    }
}
