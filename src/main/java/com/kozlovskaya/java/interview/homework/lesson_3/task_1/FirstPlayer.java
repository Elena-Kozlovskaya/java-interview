package com.kozlovskaya.java.interview.homework.lesson_3.task_1;

public class FirstPlayer implements Runnable {
    private Table table;
    private static final String action = "Pong";

    public FirstPlayer(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            table.doPong(action);
        }
    }
}
