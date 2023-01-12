import Prog1Tools.IOTools;

public class TaschenrechnerIfThenElse {
    public static void main(String[] args) {
        //Calculator greeting
        System.out.println("Welcome to the ultimate calculator!!");
        // Read numbers and operators
        int operand1;
        int operand2;
        operand1 = IOTools.readInteger("Please enter a number: ");
        operand2 = IOTools.readInteger("Please enter a second number: ");
        char operator;
        operator = IOTools.readChar("Please enter one of the following characters (+,-,*,/,%): ");
        int result = 0;
        //System.out.printIn(operator)
        //Calculator
        if (operator == '+') {
            result = operand1 + operand2;
        }
        else if (operator == '-') {
            result = operand1 - operand2;
        }
        else if (operator == '*') {
            result = operand1 * operand2;
        }
        else if (operator == '/') {
            result = operand1 / operand2;
        }
        else if (operator == '%') {
            result = operand1 % operand2;
        }
        //Output
        System.out.println(operand1 + "" + operator + "" + operand2 + "" + result);
    }
}