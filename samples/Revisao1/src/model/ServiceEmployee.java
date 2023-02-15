package model;

import exceptions.NotAuthorizedException;
import model.enums.Role;

import java.util.InputMismatchException;
import java.util.function.Consumer;

public class ServiceEmployee extends Employee {
    public ServiceEmployee(String name, String nickname, int age) {
        super(name, nickname, age, Role.SERVICE);
    }

    @Override
    protected Consumer<Employee> upgrade() {
        return (employee) -> {
            switch (employee.getRole()) {
                case BASIC -> employee.setRole(Role.SERVICE);
                case MANAGER, SERVICE -> throw new NotAuthorizedException();
                default -> throw new InputMismatchException();
            }
        };
    }
}
