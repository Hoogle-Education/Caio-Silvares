import exceptions.InvalidRequestException;
import model.Request;
import view.ClientMenu;

public class Application {
    public static void main(String[] args) {

        if( !ClientMenu.firstTimeMenu() ) {
            System.err.println("The authentication key is incorrect.");
            return;
        }

        do {

            try {
                Request request = ClientMenu.mainMenu();
                if(request == null) break;

                switch (request.getOperationStatusCode()){
                    case REGISTER -> request.setClient();
                }
            } catch (InvalidRequestException requestException) {
                System.err.println("enter a valid command");
            }

        } while(true);
    }
}