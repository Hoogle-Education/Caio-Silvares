import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {

        Socket socket = new Socket("localhost", 12345);

        PrintWriter clientOutput = new PrintWriter(socket.getOutputStream(), true);
        for(int i = 0; i < 10; i++) {
            clientOutput.println("message " + i);
            Thread.sleep(3000);
        }

        socket.close();
    }
}