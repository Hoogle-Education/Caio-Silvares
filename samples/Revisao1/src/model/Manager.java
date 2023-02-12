package model;

import model.enums.Role;

public class Manager extends Employee{
    public Manager(String name, String nickname, int age, Role role) {
        super(name, nickname, age, role);
    }
}
