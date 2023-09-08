import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] bombas = new int[n+2];
        int[] contador = new int[n];

        bombas[0] = 0;
        bombas[n+1] = 0;

        // 0 | 0 1 1 0 1 | 0
        //     1 2 2 2 1

        // entrada - indexar em 1
        for(int i = 1; i <= n; i++) {
            bombas[i] = scanner.nextInt();
        }

        for(int i = 0; i < n; i++) {
            System.out.println("i:" + (i) + " | i+1:" + (i+1) + " | i+2:" + (i+2));
            contador[i] = bombas[i] + bombas[i+1] + bombas[i+2];
        }

        for( int i = 0; i < n; i++) {
            System.out.println(contador[i]);
        }

    }
}