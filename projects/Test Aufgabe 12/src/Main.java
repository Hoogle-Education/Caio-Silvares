import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//            0 {name} {sec_nr}
//            0 John 42
//            Unblock: Unblocks a given user.
//
//            1 {name} {sec_nr}
//            1 John 42
//            Delete: Deletes a given user.
//
//            2 {name} {sec_nr}
//            2 John 42
//            GetSalePrices: Gets the current sale prices.
//
//            3
//            GetPurchasePrices: Gets the current purchase prices.

public class Main {

    private static final String  AUTHENTICATION_KEY = "483161";

    public static void sendToServer(String... messages) {
        List<String> messageList = null;

        try {
            Socket socket = new Socket("vm3.mcc.tu-berlin.de", 8080);
            OutputStream writer = socket.getOutputStream();
            InputStream reader = socket.getInputStream();
            messageList = new ArrayList<>(Arrays.asList(messages));

            for(var msg : messages) {
                var convertedMsg = msg.getBytes(StandardCharsets.UTF_8);
                byte endOfCommand = -1;
                System.out.println(msg + " : sending...");

                writer.write(convertedMsg);
                writer.write(endOfCommand);

                messageList.remove(0);

                // Lê a resposta do servidor
                byte[] responseBytes = new byte[20];
                int length = reader.read(responseBytes);
                String response = new String(responseBytes, 0, length, StandardCharsets.UTF_8).trim();
                System.out.println(response);
            }

        } catch (SocketException socketException) {
            System.out.println("trying to send again...");
            sendToServer(messageList.get(0));
        } catch (Exception e) {
            System.out.println("Error! Exception : " + e);
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        sendToServer(AUTHENTICATION_KEY, "0 Lucas 423");

        //            var command = "0 Lucas 423".getBytes();
        //            var endOfCommand = new byte[] {-1};

    }
}