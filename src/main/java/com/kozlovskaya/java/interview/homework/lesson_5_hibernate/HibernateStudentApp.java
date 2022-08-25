package com.kozlovskaya.java.interview.homework.lesson_5_hibernate;

public class HibernateStudentApp {
    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();

        try {
            StudentDao studentDao = new StudentDaoImpl(sessionFactoryUtils);
            for (int i = 1; i <= 1000; i++) {
                studentDao.saveOrUpdate(new Student());
            }
            System.out.println("Number of students in the DB = " + studentDao.findAll().size());

            Student student = studentDao.findById(1L);
            student.setName("Ivan");
            student.setMark(5);
            studentDao.saveOrUpdate(student);
            Student student1 = studentDao.findById(1L);
            System.out.println("Student name is: " + student1.getName()
            + " mark = " + student1.getMark());

            studentDao.deleteById(35L);
            System.out.println("Number of students in the DB = " + studentDao.findAll().size());
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shutdown();
        }
    }
}
