package org.example.module17._2;

import java.lang.reflect.InvocationTargetException;

public class ObjectFactory {
    static<T> T create(Class<T> clazz) {
        T instance = null;
        try {
            instance = clazz.getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }
}
