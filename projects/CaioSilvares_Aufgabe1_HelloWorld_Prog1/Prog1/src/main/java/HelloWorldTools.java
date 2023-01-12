import Prog1Tools.IOTools;

public class HelloWorldTools {
    public static void main(String[] args) {
        String name = IOTools.readLine("Enter your name: ");
        System.out.println("Hello " + name + "!");
    }
}
