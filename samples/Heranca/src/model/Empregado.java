package model;

public class Empregado {

    private String nome;
    private int age;
    private int salary;
    private Trabalho trabalho;

    public Empregado() {
    }

    public Empregado(String nome, int age, int salary) {
        this.nome = nome;
        this.age = age;
        this.salary = salary;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Trabalho getTrabalho() {
        return trabalho;
    }

    public boolean hasTrabalho() {
        return this.trabalho != null;
    }

    public void quitTrabalho() {
        this.trabalho = null;
    }

    public void assignTrabalho(Trabalho trabalho) {
        this.trabalho = trabalho;
    }
}
