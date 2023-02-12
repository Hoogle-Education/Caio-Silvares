import model.Employee;
import model.enums.Role;

public class Main {
    public static void main(String[] args) {

        Employee emp1 = new Employee("John", "JJ", 25, Role.SERVICE);

        System.out.println(emp1);
        emp1.upgrade();
        System.out.println(emp1);

        System.out.println("Name: " + emp1.getName());

    }
}