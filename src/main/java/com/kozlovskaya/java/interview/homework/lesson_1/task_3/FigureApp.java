package com.kozlovskaya.java.interview.homework.lesson_1.task_3;

public class FigureApp {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setDiameter(5.0);
        circle.getSquare();

        Triangle triangle = new Triangle();
        triangle.setLegA(3.0);
        triangle.setLegB(4.0);
        triangle.getSquare();

        Triangle triangle1 = new Triangle();
        triangle1.setLegA(7.0);
        triangle1.setLegB(9.0);
        triangle1.getSquare();

        Square square = new Square();
        square.setSide(6.0);
        square.getSquare();

    }
}
