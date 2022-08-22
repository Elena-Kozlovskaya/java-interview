package com.kozlovskaya.java.interview.homework.lesson_3.task_1;


public class Table {
    private volatile boolean switchAction = true;

    public synchronized void doPing(String point) {
            if (!switchAction) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        System.out.println(Thread.currentThread().getName() + " - " + point);
            switchAction = false;
            notify();
    }

    public synchronized void doPong(String point) {
            if (switchAction) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        System.out.println(Thread.currentThread().getName() + " - " + point);
            switchAction = true;
            notify();
    }
}
