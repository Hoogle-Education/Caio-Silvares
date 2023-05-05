import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Horse horse1 = new Horse("john");
        Horse horse2 = new Horse("martha");
        Horse horse3 = new Horse("luther");
        Horse horse4 = new Horse("beatrice");

        Thread t1 = new Thread(horse1);
        Thread t2 = new Thread(horse2);
        Thread t3 = new Thread(horse3);
        Thread t4 = new Thread(horse4);
        // t1.start(); // paralelo

        List<Thread> threadPool = new ArrayList<>();
        threadPool.add(t1);
        threadPool.add(t2);
        threadPool.add(t3);
        threadPool.add(t4);

        threadPool.forEach(t -> {
            t.start();
        });

    }

}