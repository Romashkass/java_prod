package org.example.module21;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Singleton {
    private int a = 1;
    private int b = 2;
    private int c = 3;

    private static volatile Singleton INSTANCE;

    private Singleton() {
    }

    public static Singleton instance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public String toString() {
        return "Singleton@" + hashCode() + "{" + a + ", " + b + ", " + c + '}';
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
//                System.out.println(Singleton.instance());
                System.out.print(Singleton.instance().a);
            }));
        }
        for (Thread thread: threads) {
            thread.start();
        }
        latch.countDown();
        for (Thread thread: threads) {
            thread.join();
        }
    }
}
