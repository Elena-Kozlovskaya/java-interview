package com.kozlovskaya.java.interview.homework.lesson_5_hibernate;

import java.util.List;

public interface StudentDao {

    void saveOrUpdate(Student student);

    Student findById(Long id);

    List<Student> findAll();

    void deleteById(Long id);

}
