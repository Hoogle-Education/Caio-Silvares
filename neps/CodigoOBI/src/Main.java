import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] codigo = new int[n];

        for (int i = 0; i < n; i++) {
            codigo[i] = scanner.nextInt();
        }

        // vetor de tamanho n: vai de zero ate n-1
        // for i = 0 ate i = n-1

        int contador = 0;

        for (int i = 0; i < n-2; i++) {
            if (codigo[i] == 1 && codigo[i + 1] == 0 && codigo[i + 2] == 0) {
                contador++;
            }
        }

        System.out.println(contador);
    }
}