import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(12345);

        System.out.println("waiting client...");
        Socket clientSocket = serverSocket.accept();
        System.out.println("connection ok!");

        BufferedReader clientInput = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String message;
        while( (message = clientInput.readLine()) != null ) {
            System.out.println("message recieved: " + message);
        }

        clientSocket.close();
        serverSocket.close();
    }
}
