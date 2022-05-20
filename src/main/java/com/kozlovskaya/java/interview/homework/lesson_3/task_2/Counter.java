package com.kozlovskaya.java.interview.homework.lesson_3.task_2;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int count;
    private final ReentrantLock lock;

    public Counter() {
        this.count = 0;
        this.lock = new ReentrantLock();
    }

    public void increment() {
        lock.lock();
        if(count < 100)
            try{
                count++;
            } finally {
                lock.unlock();
            }
    }

    public void decrement() {
        lock.lock();
        if(count > 0)
            try{
                count--;
            } finally {
                lock.unlock();
            }
    }

    public synchronized int getCount() {
        return count;
    }
}
