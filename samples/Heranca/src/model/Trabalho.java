package model;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Trabalho {

    private String nome;
    private Duration duration;
    private List<Empregado> empregados;

    public Trabalho() {
        empregados = new ArrayList<>();
    }

    public Trabalho(String nome, Duration duration) {
        empregados = new ArrayList<>();
        this.nome = nome;
        this.duration = duration;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public List<Empregado> getEmpregados() {
        return empregados;
    }

    public void addEmpregado(Empregado empregado) {
        empregados.add(empregado);
    }

    public boolean removeEmpregado(Empregado empregado){
        return empregados.remove(empregado);
    }
}
