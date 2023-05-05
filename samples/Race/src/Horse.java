import java.util.Random;

public class Horse implements Runnable {

    private String name;

    public Horse(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " start to run");
        int distance = 100;
        int point = 0;
        Random random = new Random();

        do {
            int pace = random.nextInt(-3, 10);
            point += pace;
            try {
                System.out.println(name);
                Thread.sleep(Math.abs(pace)*100);
            } catch (InterruptedException ignored) {
            }

        } while (point < 100.0);

        try {
            System.out.println(name + " has stop to run");
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
    }


}
