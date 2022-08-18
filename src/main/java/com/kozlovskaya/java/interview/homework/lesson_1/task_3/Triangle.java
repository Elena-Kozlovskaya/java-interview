package com.kozlovskaya.java.interview.homework.lesson_1.task_3;

public class Triangle extends Figure{

    private double legA;
    private double legB;
    private double hypotenuse;

    @Override
    void getSquare() {
        double result = (legA * legB)/2;
        System.out.println("Площадь прямоугольного треугольника = " + result);
    }

    public double getLegA() {
        return legA;
    }

    public void setLegA(double legA) {
        this.legA = legA;
    }

    public double getLegB() {
        return legB;
    }

    public void setLegB(double legB) {
        this.legB = legB;
    }

    public double getHypotenuse() {
        return hypotenuse;
    }

    public void setHypotenuse(double hypotenuse) {
        this.hypotenuse = hypotenuse;
    }
}
