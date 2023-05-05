import annotations.Printable;
import annotations.PrintableField;
import models.User;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        User user = new User("test", "test@gmail.com", "p123");
        printUser(user);

    }

    private static void printUser(User user) throws IllegalAccessException {
        var userClass = user.getClass();
        if(!userClass.isAnnotationPresent(Printable.class))
            throw new IllegalStateException("This class is not printable");

        var annotations = userClass.getDeclaredAnnotations();
        for(var annotation : annotations) {
            if(annotation instanceof Printable printable) {
                for(var field : userClass.getDeclaredFields()) {
                    if(!field.isAnnotationPresent(PrintableField.class))
                        continue;

                    field.setAccessible(true);
                    PrintableField printableField = field.getAnnotation(PrintableField.class);
                    // ternary operator
                    String key = printableField.key().isBlank() ? field.getName() : printableField.key();
                    System.out.println(key + ": " + field.get(user));
                }
            }
        }
    }

    private static boolean isFieldPresent(String[] fields, String targetField) {
        return Arrays.stream(fields).anyMatch(f -> f.equals(targetField));
    }
}