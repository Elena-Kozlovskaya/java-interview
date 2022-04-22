package com.kozlovskaya.java.interview.homework.lesson_1.task_1;

public class PersonTest {
    public static void main(String[] args) {
        Person person = new Person.Builder()
                .firstName("Vasya")
                .lastName("Popov")
                .address("Lenina str")
                .middleName("-")
                .gender("male")
                .phone("123-789-234")
                .country("Russia")
                .age(27)
                .build();

        System.out.println(person);
    }
}
