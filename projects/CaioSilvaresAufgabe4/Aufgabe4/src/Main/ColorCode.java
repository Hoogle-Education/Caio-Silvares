package Main;
import Prog1Tools.IOTools;
import java.util.Arrays;

public class ColorCode {
    public static void main(String[] args) {

        char[] computerArray = generateRandomArray();
        char[] userArray = generateRandomArray();
        changeArray(userArray);
        System.out.println(arrayToString(userArray));
        System.out.println(Arrays.toString(analyzeArray(computerArray, userArray)));
    }

    public static char[] generateRandomArray() {
        char[] ran_array = new char[4];
        char[] color = {'y', 'o', 'r', 'g', 'c', 'b'};

        for (int i = 0; i < ran_array.length; i++) {
            int index = (int) (Math.random() * color.length);
            ran_array[i] = color[index];
        }
        return ran_array;
    }

    public static String arrayToString(char[] charArray) {
        String s = (charArray[0] + "." + charArray[1] + "." + charArray[2] + "." + charArray[3]);
        return s;
    }

    public static void changeArray(char[] charArray) {
        char done = 'n';

        while (done == 'n') {
            System.out.println("try ...");
            System.out.println("Current Array: " + arrayToString(charArray));
            int n = IOTools.readInt("Which index: ");

            if (n == 0 || n == 1 || n == 2 || n == 3) {
                char letter = IOTools.readChar("Which char?: ");

                if (letter == 'y' || letter == 'o' || letter == 'r' || letter == 'g' || letter == 'c' || letter == 'b') {
                    charArray[n] = letter;
                    System.out.println("Change Array: " + arrayToString(charArray));
                } else {
                    System.out.println("Invalid character (" + letter + ") repeat");
                }
            } else {
                System.out.println("Invalid index (" + n + ") repeat");
            }
            done = IOTools.readChar("Done? (y/n): ");
        }
    }

    public static int[] analyzeArray(char[] computerArray, char[] userArray) {
        int a = 0;
        int b = 0;

        for (int x = 0; x < computerArray.length; x++) {
            if (computerArray[x] == userArray[x]) {
                a++;
            } else {
                for (int y = 0; y < userArray.length; y++) {
                    if (computerArray[x] == userArray[y]) {
                        b++;
                        break;
                    }
                }
            }
        }
        System.out.println("A:" + a + ", B:" + b);
        return new int[]{a, b};
    }

}