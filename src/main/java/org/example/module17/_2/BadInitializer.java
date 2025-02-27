package org.example.module17._2;

import java.lang.reflect.Field;

public class BadInitializer extends Initializer {
    static <T> T initialize(T target, String fieldName, Object value) {
        try {
            Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return target;
    }
}
