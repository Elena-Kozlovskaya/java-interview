package com.kozlovskaya.java.interview.homework.lesson_3.task_1;

public class SecondPlayer implements Runnable{
    private Table table;
    private static final String action = "Ping";


    public SecondPlayer(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            table.doPing(action);
        }

    }
}
