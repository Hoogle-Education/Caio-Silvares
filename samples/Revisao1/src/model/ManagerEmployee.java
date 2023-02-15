package model;

import exceptions.NotAuthorizedException;
import model.enums.Role;

import java.util.InputMismatchException;
import java.util.function.Consumer;

public class ManagerEmployee extends Employee{
    public ManagerEmployee(String name, String nickname, int age) {
        super(name, nickname, age, Role.MANAGER);
    }

    @Override
    protected Consumer<Employee> upgrade() {
        return (employee) -> {
            switch (employee.getRole()) {
                case BASIC -> employee.setRole(Role.SERVICE);
                case SERVICE -> employee.setRole(Role.MANAGER);
                case MANAGER -> throw new NotAuthorizedException();
                default -> throw new InputMismatchException();
            }
        };
    }
}
