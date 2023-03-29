import model.Carro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Carro carro1 = new Carro("Ferrari", "123ABC", 2018);
        Carro carro2 = new Carro("BMW", "231BCA", "Herby", 2010);
        Carro carro3 = new Carro("BMW", "231BCA", "Herby", 2010);
        Carro carro4 = new Carro("BMW", "231BCA", "Herby", 2010);
        Carro carro5 = new Carro("BMW", "231BCA", "Herby", 2010);
        Carro carro6 = new Carro("BMW", "231BCA", "Herby", 2010);
        Carro carro7 = new Carro("BMW", "231BCA", "Herby", 2010);
        Carro carro8 = new Carro("BMW", "231BCA", "Herby", 2010);
        Carro carro9 = new Carro("BMW", "231BCA", "Herby", 2010);

        carro1.abastecer(200);
        carro1.ligar();
        System.out.println(carro1.isLigado());
        carro1.desligar();
        System.out.println(carro1.isLigado());

    }
}