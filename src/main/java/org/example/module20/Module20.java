package org.example.module20;

import java.util.concurrent.*;

public class Module20 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new T().start();
        new Thread(new R()).start();
        Runnable anonymous = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous class");
            }
        };
        new Thread(anonymous).start();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> future = executorService.submit(new C());
        System.out.println(future.get());
    }

    static class T extends Thread {
        @Override
        public void run() {
            System.out.println("Thread extension");
        }
    }
    static class R implements Runnable {
        @Override
        public void run() {
            System.out.println("Runnable implementation");
        }
    }
    static class C implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "Callable implementation";
        }
    }
}
