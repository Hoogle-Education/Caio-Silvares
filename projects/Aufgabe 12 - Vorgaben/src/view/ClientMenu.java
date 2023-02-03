package view;

import Prog1Tools.IOTools;
import exceptions.InvalidRequestException;
import model.Request;
import model.enums.OperationStatusCode;
import util.Constraints;

public class ClientMenu {

    private static void addBorder() {
        System.out.println("-------------------------------");
    }
    public static boolean firstTimeMenu(){
        System.out.println("Welcome to the PROG1 trading system!");
        int authencationKey = IOTools.readInt("Please, enter your authentication key: ");
        return authencationKey == Constraints.AUTHENTICATION_KEY;
    }

    public static Request mainMenu()
        throws InvalidRequestException {
        addBorder();
        System.out.println("Please, enter one of the following commands:");
        System.out.println("0 - login");
        System.out.println("1 - register user");
        System.out.println("2 - unblock user");
        System.out.println("3 - deleter user");
        System.out.println("4 - to exit");
        int optionNumber = IOTools.readInt("> ");

        if(optionNumber == Constraints.EXIT_OPTION_NUMBER) {
            return null;
        }

        return new Request(optionNumber);
    }

}
