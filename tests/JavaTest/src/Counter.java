public class Counter implements Runnable {

    public static void main(String[] args) {
        var myCounter = new Counter();
        var myThread = new Thread(myCounter);
        myThread.start();
    }

    @Override
    public void run() {
        for(int i = 0; i < 50; i++){
            if(i == 40) continue;

            if(i%4 == 0)
                System.out.println(i);
        }
    }
}
