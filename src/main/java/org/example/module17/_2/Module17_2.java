package org.example.module17._2;

public class Module17_2 {
    public static void main(String[] args) {
        Apple apple = ObjectFactory.create(Apple.class);
        Initializer.initialize(apple, "weight", 15.0);
        Initializer.initialize(apple, "color", "green");
        System.out.println(apple);
    }
}
