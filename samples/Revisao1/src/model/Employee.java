package model;

// classe ok
// objeto ok
// atributo ok
// método ok
// privacidade/encapsualmento -
// construtor ok
// get set ok
// herança
// interface
// enum ok
// static

import model.enums.Role;

import java.util.function.Consumer;
import java.util.function.Predicate;

public abstract class Employee {

    // atributos
    private String name;
    private String nickname;
    private int age;
    private double baseSalary;
    private Role role;
    private double fee;
    private boolean active;

    // constructors
    private Employee(String name, int age, Role role) {
        this.name = name;
        this.age = age;
        this.active = true;
        this.role = role;
        updateSalaryAndFee();
    }

    public Employee(String name, String nickname, int age, Role role) {
        this(name, age, role);
        this.nickname = nickname;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        if(nickname == null)
            return;

        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getFee() {
        return fee;
    }

    public double getSalary() {
        return baseSalary - fee;
    }

    public boolean isActive() {
        return active;
    }

    public Role getRole() {
        return role;
    }

    protected void setRole(Role role) {
        this.role = role;
    }

    // methods
    protected abstract Consumer<Employee> upgrade();

    public void upgrade(Employee employee) {
        upgrade().accept(employee);
        employee.updateSalaryAndFee();
    }

    private void updateSalaryAndFee() {
        switch (role) {
            case MANAGER -> {
                baseSalary = 10000;
                fee = 2.000;
            }
            case SERVICE -> {
                baseSalary = 6000;
                fee = 1500;
            }
            case BASIC -> {
                baseSalary = 3000;
                fee = 500;
            }
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                ", salary=" + getSalary() +
                ", role=" + role +
                '}';
    }
}
