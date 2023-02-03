import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        try (Socket socket = new Socket("vm3.mcc.tu-berlin.de", 8080)) {
            OutputStream writter = socket.getOutputStream();
            InputStream reader = socket.getInputStream();
            var authKey = "483161".getBytes();
            var command = "3".getBytes();
            var endOfCommand = new byte[] {-1};

            writter.write(authKey);
            writter.write(endOfCommand);
//            0 {name} {sec_nr}
//            0 John 42
//            Unblock: Unblocks a given user.
//
//            1 1 {name} {sec_nr}
//            1 John 42
//            Delete: Deletes a given user.
//
//            2 2 {name} {sec_nr}
//            2 John 42
//            GetSalePrices: Gets the current sale prices.
//
//            3 3
//            3
//            GetPurchasePrices: Gets the current purchase prices
//            prices.



            var responseBytes = reader.read();
            StringBuilder response = new StringBuilder();
            while(responseBytes != -1) {
                response.append((char) responseBytes);
                responseBytes = reader.read();
            }
            System.out.println(response);

            writter.write(command);
            writter.write(endOfCommand);

            responseBytes = reader.read();
            response = new StringBuilder();
            while(responseBytes != -1) {
                response.append((char) responseBytes);
                responseBytes = reader.read();
            }
            System.out.println("bytes: " + responseBytes);
            System.out.println("Command Reponse: " + response);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}