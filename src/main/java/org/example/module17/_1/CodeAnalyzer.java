package org.example.module17._1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class CodeAnalyzer {
    public static void analyzeClass(Object o) {
        Class<? extends Object> clazz = o.getClass();
        System.out.println("1. " + clazz.getCanonicalName());
        System.out.println("2. " + clazz.getClassLoader());
        System.out.println("3. ");
        for (Class iface: clazz.getInterfaces()) {
            System.out.println("\t" + iface.getCanonicalName());
            for (Method m: iface.getMethods()) {
                System.out.println("\t\t" + m);
            }
            System.out.println("\t----------------------");
        }
        System.out.print("4. ");
        Class superClass = clazz;
        while (superClass != null) {
            System.out.print(superClass.getCanonicalName() + "; ");
            superClass = superClass.getSuperclass();
        }
        System.out.println();
        System.out.println("5. ");
        for (Field field: clazz.getDeclaredFields()) {
            System.out.println("\t" + field);
            for (Annotation an: field.getDeclaredAnnotations()) {
                System.out.println("\t\t" + an);
            }
        }
        System.out.println("6. ");
        for (Constructor constructor: clazz.getDeclaredConstructors()) {
            System.out.println("\t" + constructor);
            for (Parameter parameter: constructor.getParameters()) {
                for (Annotation an: parameter.getDeclaredAnnotations()) {
                    System.out.println("\t\t" + an);
                }
            }
            for (Annotation an: constructor.getDeclaredAnnotations()) {
                System.out.println("\t" + an);
            }
            System.out.println("\t----------------------");
        }
        System.out.println("7. ");
        for (Method method: clazz.getDeclaredMethods()) {
            System.out.println("\t" + method);
            for (Parameter parameter: method.getParameters()) {
                for (Annotation an: parameter.getDeclaredAnnotations()) {
                    System.out.println("\t\t" + an);
                }
            }
            for (Annotation an: method.getDeclaredAnnotations()) {
                System.out.println("\t" + an);
            }
            System.out.println("\t----------------------");
        }
        System.out.println("8. ");
        for (Annotation an: clazz.getDeclaredAnnotations()) {
            System.out.println("\t" + an);
        }
    }
}
