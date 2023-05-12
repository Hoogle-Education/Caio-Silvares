package utils;

import models.User;
import models.annotations.JsonIgnore;
import models.annotations.JsonKey;
import models.annotations.JsonParser;
import models.annotations.Jsonable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Log4Json {

    public static String toJson(Object object) throws Exception {
        if (!isJsonable(object))
            return "{ not a jsonable }";

        runObjectParsers(object);
        var jsonString = getObjectAsJsonString(object);
        return "{\n" + jsonString + "\n }";
    }

    private static String getObjectAsJsonString(Object object)
            throws IllegalAccessException {
        var jsonElements = getKeyValueMapFromObject(object);

        var quoteMark = "\"";
        var tab = "\t";
        var jsonString = jsonElements.entrySet()
                .stream()
                .map(entry -> tab + quoteMark + entry.getKey()
                        + quoteMark + " : " + quoteMark
                        + entry.getValue() + quoteMark)
                .collect(Collectors.joining(",\n"));


        return jsonString;
    }

    private static Map<String, String> getKeyValueMapFromObject(Object object) throws IllegalAccessException {
        Map<String, String> jsonElements = new HashMap<>();
        Class<?> objectClass = object.getClass();

        for(var field : objectClass.getDeclaredFields()) {
            field.setAccessible(true);
            if(field.isAnnotationPresent(JsonIgnore.class))
                continue;

            var key = getKey(field);
            var value = (String) field.get(object).toString();
            jsonElements.put(key, value);
        }

        return jsonElements;
    }

    private static boolean isJsonable(Object object) {
        if(Objects.isNull(object)) {
            System.err.println("The object is not jsonable bc is null");
            return false;
        }

        Class<?> objectClass = object.getClass();
        if(!objectClass.isAnnotationPresent(Jsonable.class)){
            System.err.println("This object is not marked as jsonable");
            return false;
        }

        return true;
    }

    private static void runObjectParsers(Object object) throws Exception {
        Class<?> objectClass = object.getClass();

        for(var method : objectClass.getMethods()) {
            if(method.isAnnotationPresent(JsonParser.class)) {
                method.setAccessible(true);
                method.invoke(object);
            }
        }
    }

    public static String getKey(Field field) {
        var key = field.getName();

        if(field.isAnnotationPresent(JsonKey.class)) {
            var annotationKey = field.getAnnotation(JsonKey.class).value();

            key = (annotationKey.isBlank()) ? key : annotationKey;
        }

        return key;
    }
}
