import Prog1Tools.IOTools;

public class CesarCipher1 {
    public CesarCipher1() {
    }

    public static void printMessage(char[] array) {
        for(int i = 0; i < array.length; ++i) {
            System.out.print(array[i]);
        }

        System.out.println();
    }

    public static char[] readChars(int Julius) {
        char[] Caesar = new char[Julius];

        for(int i = 0; i < Caesar.length; ++i) {
            Caesar[i] = IOTools.readChar("Please enter the letters for position" + i + ":");
        }

        return Caesar;
    }

    public static void main(String[] args) {
        int Lenght = IOTools.readInt("Enter the number of characters which shall be read:");
        char[] array = readChars(Lenght);
    }
}