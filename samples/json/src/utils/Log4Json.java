package utils;

import models.User;
import models.annotations.JsonParser;
import models.annotations.Jsonable;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class Log4Json {

    public static String serialize(User user) throws Exception {
        String aux = "{";

        if (!isJsonable(user))
            return aux + "}";

        runObjectParsers(user);
        aux += getObjectAsJson(user);
        return aux + "}";
    }

    private static String getObjectAsJson(User user) {
        String aux = "";
        // TODO convert object fields to Json model
        return "";
    }

    private static boolean isJsonable(Object object) {
        if(Objects.isNull(object)) {
            System.err.println("The object is not jsonable bc is null");
            return false;
        }

        Class<?> objectClass = object.getClass();
        if(!objectClass.isAnnotationPresent(Jsonable.class)){
            System.err.println("This object is not maked as jsonable");
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
}
