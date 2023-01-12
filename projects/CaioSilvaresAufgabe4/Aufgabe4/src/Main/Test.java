package Main;
import Prog1Tools.IOTools;
/**import java.util.Arrays;
 */

public class Test {
    public static void main(String[] args){
        //char[] color = {'y', 'o', 'r', 'g', 'c', 'b'};
        //printArray(array);

        //char[] ran_array = generateRandomArray(color);
        //System.out.println(Arrays.toString(ran_array).replace(",", "."));
        char[] computerArray = generateRandomArray();
        char[] userArray = generateRandomArray();
        changeArray(userArray);
        System.out.println(arrayToString(userArray));
        /**
         * System.out.println(analyzeArray(computerArray, userArray));
         * --> System.out.println(Arrays.toString(analyzeArray(computerArray, userArray)));
         */
        //System.out.println("try ...");
        //analyzeArray(computerArray, userArray);
    }

    public static char[] generateRandomArray(){
        char[] charArray = new char[4];
        char[] color = {'y', 'o', 'r', 'g', 'c', 'b'};

        for (int i = 0; i < charArray.length; i++) {
            int index = (int) (Math.random() * color.length);
            charArray[i] = color[index];
        }
        return charArray;
    }

    public static String arrayToString(char[] charArrayS){
        String s = (charArrayS[0] + "." + charArrayS[1] + "." + charArrayS[2] + "." + charArrayS[3]);
        return s;
    }

    public static void changeArray(char[] charArrayC){
        char done = 'n';

        while (done == 'n') {
            System.out.println("try ...");
            System.out.println("Current Array: " + arrayToString(charArrayC));
            int n = IOTools.readInt("Which index: ");

            if (n == 0 || n == 1 || n == 2 || n == 3) {
                char letter = IOTools.readChar("Which char?: ");

                if (letter == 'y' || letter == 'o' || letter == 'r' || letter == 'g' || letter == 'c' || letter == 'b') {
                    charArrayC[n] = letter;
                    System.out.println("Change Array: " + arrayToString(charArrayC));
                }
                else{
                    System.out.println("Invalid character (" + letter + ") repeat");
                }
            }
            else{
                System.out.println("Invalid index (" + n + ") repeat");
            }
            done = IOTools.readChar("Done? (y/n): ");
        }
    }

    public static int[] analyzeArray(char[] computerArray, char[] userArray){
        int[] AB = new int[2];

        for (int i = 0; i < computerArray.length; i++){
            for (int j = 0; j < userArray.length; j++){
                if (computerArray[j] == userArray[i]){
                    if (i == j){
                        AB[0]++;
                    }
                    else{
                        AB[1]++;
                    }
                    break;
                }
            }
        }
        //System.out.println();
        return AB;
    }

    //public static void changeArray(char[] array){
    // String command = IOTools.readLine("To continue please enter y/n: ");
    // while (command.equals("y")){
    //   char[] current_array = new char[];
    //   System.out.println("Current Array " + array);

    //   int re_index = IOTools.readInt("Which index?: ");
    // int re_char = IOTools.readChar("Which car?: ");

    //if(re_index < 4){
    //  boolean contains = false;
    //for(int i = 0; i < array.length; i++){
    //  if(array[i] == re_char){
    //    array[re_index] = re_char;
    //}
    //else if (!contains){
    //  System.out.println("Invalid character " + re_char + "repeat: ");
    //}
    //}
    //}

    //public static int[] analyze


    //}
    /**
     * public static int[] analyzeArray (char[] computerArray, char[] userArray){
     *
     *     int a = 0;
     *     int b = 0;
     *
     *     for (int x = 0; x < computerArray.length; x++){
     *         if (computerArray[x] == userArray[x]){
     *             a++;
     *         }
     *         else{
     *             for (int y = 0; y < userArray.length; y++){
     *                 if (computerArray[x] == userArray[y]){
     *                     b++;
     *                     break;
     *                 }
     *             }
     *         }
     *     }
     *     System.out.println("A:" + a + ", B:" + b);
     *     return new int[]{a, b};
     * }
     */

}
