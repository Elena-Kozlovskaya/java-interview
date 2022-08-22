package com.kozlovskaya.java.interview.homework.lesson_3.task_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CounterApp {

    public static void main(String[] args) {
        Counter counter = new Counter();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> {
            try {
                for (int i = 0; i < 54; i++) {
                    counter.increment();
                }
                System.out.println(counter.getCount());

                for (int i = 0; i < 20; i++) {
                    counter.decrement();
                }
                System.out.println(counter.getCount());
            } finally {
                executor.shutdown();
            }
        });





    }
}
