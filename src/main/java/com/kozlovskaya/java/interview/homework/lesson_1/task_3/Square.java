package com.kozlovskaya.java.interview.homework.lesson_1.task_3;

public class Square extends Figure {

    private double side;

    @Override
    void getSquare() {
        double result = Math.pow(side, 2);
        System.out.println("Площадь квадрата = " + result);
    }

    void getSquare(double a, double b){
        System.out.println("Другая площадь квадрата = " + (a * b));
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}
