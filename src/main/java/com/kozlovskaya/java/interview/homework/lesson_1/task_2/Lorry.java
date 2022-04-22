package com.kozlovskaya.java.interview.homework.lesson_1.task_2;

// ошибки в сигнатуре класса - Moveable, Stopable интерфейсы должны быть implements
// public class Lorry extends Car implements Moveable, Stopable
// класс не имеет своих уникальных полей, соотв. конструкторов, геттеров, сеттеров
// нет реализации абстрактного метода open()
// можно переопределить метод start()
// добавить аннотации @Override над методами
// желательно переопределить метод toString для отладки
/*public class Lorry extends Car, Moveable, Stopable {


    public void move(){
        System.out.println("Car is moving");
    }

    public void stop(){
        System.out.println("Car is stop");
    }

}*/
