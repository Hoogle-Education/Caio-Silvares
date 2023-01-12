import Prog1Tools.IOTools;

public class TaschenrechnerMitSwitchCase {
    public static void main(String[] args) {
        //Greetings
        System.out.println("Welcome to the ultimate calculator once again!!");
        //Calculating
        int operand1 = IOTools.readInteger("Please enter a number: ");
        int operand2 = IOTools.readInteger("Please enter a second number: ");
        char operator = IOTools.readChar("Please enter one of the following characters (+,-,*,/,%): ");
        int result = 0;

        switch (operator) {
            case '+': {
                result = operand1 + operand2;
                break;
            }
            case '-': {
                result = operand1 - operand2;
                break;
            }
            case '*': {
                result = operand1 * operand2;
                break;
            }
            case '/': {
                result = operand1 / operand2;
                break;
            }
            case '%': {
                result = operand1 % operand2;
                break;
            }
        }
        //Result
        System.out.println(result);
    }
}