package se.reflection.lee;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {



    }

    private static void setObjectColor(Object obj, Color color) {
        Class cls = obj.getClass();

        try {
            Method method = cls.getMethod("setColor", new Class[]{Color.class});
            method.invoke(obj, new Object[]{color});
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException(cls.getName()
                    + " does not support method setColor(Color)");
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);

        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Insufficient access " +
                    "permissions to call" + "setColor(:Color in class "
                    + cls.getName());
        }

    }


}
