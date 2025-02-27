package org.example.module17._2;

public class Initializer {
    static <T> T initialize(T target, String fieldName, Object value) {
        String methodName = "set" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
        try {
            target.getClass().getMethod(methodName, value.getClass()).invoke(target, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return target;
    }
}
