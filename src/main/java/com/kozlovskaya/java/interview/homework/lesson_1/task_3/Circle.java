package com.kozlovskaya.java.interview.homework.lesson_1.task_3;

public class Circle extends Figure{

    private double diameter;

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    @Override
    void getSquare() {
        double result = Math.pow(diameter, 2) / 4 * Math.PI;
        System.out.println("Площадь круга = " + result);
    }

}
