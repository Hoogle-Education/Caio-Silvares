package service;

import model.Empregado;
import model.Trabalho;

import java.util.ArrayList;
import java.util.List;

public class EnterpriseService {

    private List<Empregado> empregados;
    private List<Trabalho> trabalhos;

    public EnterpriseService() {
        empregados = new ArrayList<>();
        trabalhos = new ArrayList<>();
    }

    public void registerNewEmpregado(Empregado empregado) {
        empregados.add(empregado);
    }

    public void registerNewTrabalho(Trabalho trabalho) {
        trabalhos.add(trabalho);
    }

    public void assignTrabalhoToEmpregado(Trabalho trabalho, Empregado empregado) {

        if(!trabalhos.contains(trabalho)) {
            System.out.println("O trabalho solicitado nao está cadastrado ainda.");
            return;
        }

        if(!empregados.contains(empregado)) {
            System.out.println("O empregado solicitado nao está cadastrado ainda.");
            return;
        }

        if(empregado.hasTrabalho()) {
            System.out.println("O empregado está ocupado com outro trabalho no momento.");
            return;
        }

        var trabalhoPosition = trabalhos.indexOf(trabalho);
        var trabalhoToAssociate = trabalhos.get(trabalhoPosition);
        var empregadoPosition = empregados.indexOf(empregado);
        var empregadoToAssociate = empregados.get(empregadoPosition);

        trabalhoToAssociate.addEmpregado(empregadoToAssociate);
        empregadoToAssociate.assignTrabalho(trabalhoToAssociate);
    }

    @Override
    public String toString() {
        String aux = "";

        for(var trabalho : trabalhos) {
            String temp = trabalho.getNome() + ": ";
            for(var empregado : trabalho.getEmpregados()) {
                temp += empregado.getNome() + ", ";
            }
            aux += temp + "\n";
        }

        return aux;
    }
}
