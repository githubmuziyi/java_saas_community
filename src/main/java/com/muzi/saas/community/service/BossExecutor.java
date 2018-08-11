package com.muzi.saas.community.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Component
public class BossExecutor {

    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void addJob() {
        System.out.println("------add job------");
        queue.add(1);
    }

    public BossExecutor() {
        ExecutorService startExecutor = Executors.newSingleThreadExecutor();
        startExecutor.execute(new Boss());
    }

    public static class Boss implements Runnable {

        @Override
        public void run() {
            ExecutorService workExecutor = Executors.newFixedThreadPool(3);
            while (true) {
                try {
                    if (queue.take() > 0) {
                        workExecutor.execute(new Work());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Work implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("----------job start-------");
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello world");
        }
    }
}
