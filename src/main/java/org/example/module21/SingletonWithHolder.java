package org.example.module21;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class SingletonWithHolder {
    private int a = 1;
    private int b = 2;
    private int c = 3;

    private SingletonWithHolder() {
    }

    public static SingletonWithHolder instance() {
        return Holder.INSTANCE;
    }

    @Override
    public String toString() {
        return "Singleton@" + hashCode() + "{" + a + ", " + b + ", " + c + '}';
    }

    private static class Holder {
        static final SingletonWithHolder INSTANCE = new SingletonWithHolder();
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
                System.out.println(SingletonWithHolder.instance());
//                System.out.print(SingletonWithHolder.instance().a);
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
