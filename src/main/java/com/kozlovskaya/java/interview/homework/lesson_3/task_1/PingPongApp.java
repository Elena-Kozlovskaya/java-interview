package com.kozlovskaya.java.interview.homework.lesson_3.task_1;

public class PingPongApp {

    public static void main(String[] args) {
        Table table = new Table();
        SecondPlayer ping = new SecondPlayer(table);
        FirstPlayer pong = new FirstPlayer(table);
        new Thread(ping).start();
        new Thread(pong).start();
    }


}
