package model;

import exceptions.NotAuthorizedException;
import model.enums.Role;

import java.util.InputMismatchException;
import java.util.function.Consumer;

public class BasicEmployee extends Employee {

    public BasicEmployee(String name, String nickname, int age) {
        super(name, nickname, age, Role.BASIC);
    }

    @Override
    protected Consumer<Employee> upgrade() {
        return (employee) -> {
            switch (employee.getRole()) {
                case MANAGER, SERVICE, BASIC -> throw new NotAuthorizedException();
                default -> throw new InputMismatchException();
            }
        };
    }

}
