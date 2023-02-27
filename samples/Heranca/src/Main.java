import model.Empregado;
import model.Trabalho;
import service.EnterpriseService;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {

//        int[] integersSequence = {1, 2, 3, 4};
//        int[] emptyIntegersSequence = new int[10];

        // System.out.println("segundo elemento do vetor: " + integersSequence[1]);
        // vetor/array
        // tamanho fixo
        // contamos a partir do zero
        // n elementos: vou da pos 0 até n-1

        Trabalho devSenior = new Trabalho("senior developer", Duration.ofHours(40));
        Trabalho devJunior = new Trabalho("junior developer", Duration.ofHours(20));
        Trabalho manager = new Trabalho("manager", Duration.ofHours(40));

        Empregado emp1 = new Empregado("joao", 20, 20);
        Empregado emp2 = new Empregado("maria", 20, 20);
        Empregado emp3 = new Empregado("beatriz", 20, 20);
        Empregado emp4 = new Empregado("pedro", 20, 20);
        Empregado emp5 = new Empregado("lucas", 20, 20);
        Empregado emp6 = new Empregado("luisa", 20, 20);
        Empregado emp7 = new Empregado("marcus", 20, 20);
        Empregado emp8 = new Empregado("caio", 20, 20);

        EnterpriseService service = new EnterpriseService();

        service.registerNewTrabalho(devSenior);
        service.registerNewTrabalho(devJunior);
        service.registerNewTrabalho(manager);

        service.registerNewEmpregado(emp1);
        service.registerNewEmpregado(emp2);
        service.registerNewEmpregado(emp3);
        service.registerNewEmpregado(emp4);
        service.registerNewEmpregado(emp5);
        service.registerNewEmpregado(emp6);
        service.registerNewEmpregado(emp7);
        service.registerNewEmpregado(emp8);

        service.assignTrabalhoToEmpregado(devSenior, emp1);
        service.assignTrabalhoToEmpregado(devSenior, emp2);
        service.assignTrabalhoToEmpregado(devSenior, emp3);
        service.assignTrabalhoToEmpregado(devJunior, emp4);
        service.assignTrabalhoToEmpregado(devJunior, emp5);
        service.assignTrabalhoToEmpregado(devJunior, emp6);
        service.assignTrabalhoToEmpregado(manager, emp7);
        service.assignTrabalhoToEmpregado(devSenior, emp7);
        service.assignTrabalhoToEmpregado(manager, emp8);

        System.out.println(service);

    }
}