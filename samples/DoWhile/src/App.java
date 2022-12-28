import java.util.Scanner;

public class App {

    public static double somar(double a, double b) {
        return a + b;
    }
    
    public static double multiplicar(double a, double b) {
        return a * b;
    }

    public static void apresentarMenu() {
        System.out.println("1 - para somar");
        System.out.println("2 - para multiplicar");
        System.out.println("0 - para sair");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Seja bem vindo a calculadora");
        int userOption;

        do {

            apresentarMenu();
            userOption = sc.nextInt();
            int a, b;

            if(userOption == 0) 
                break;

            System.out.print("Digite a primeira variavel");
            a = sc.nextInt();
            
            System.out.print("Digite a segunda variavel");
            b = sc.nextInt();

            switch (userOption){
                case 1 -> System.out.println("A soma vale " + somar(a, b));
                case 2 -> System.out.println("A multiplicacao vale " + multiplicar(a, b));
            }

        } while(true);

    }
}
