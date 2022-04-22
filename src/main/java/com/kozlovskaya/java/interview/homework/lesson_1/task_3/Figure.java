package com.kozlovskaya.java.interview.homework.lesson_1.task_3;

public abstract class Figure {
    private String name;

    abstract void getSquare();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
