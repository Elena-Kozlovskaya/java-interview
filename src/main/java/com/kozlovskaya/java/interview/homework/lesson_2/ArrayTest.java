package com.kozlovskaya.java.interview.homework.lesson_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayTest {
    public static void main(String[] args) {
       /* MyArrayList<Integer> myArrayList = new MyArrayList<>(15);
        System.out.println(myArrayList.isEmpty());
        System.out.println(myArrayList.size());
        myArrayList.add(1);
        System.out.println(myArrayList.size());
        System.out.println(myArrayList.get(0));
        myArrayList.add(8);
        myArrayList.add(4);

        System.out.println(myArrayList.size());

        int el = myArrayList.remove(2);
        System.out.println(el);

        System.out.println(myArrayList.size());

        System.out.println(myArrayList.isEmpty());*/

        /*List<Integer> list = new ArrayList<>(15);
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        list.add(1);
        System.out.println(list.size());
        System.out.println(list.get(0));
        list.add(8);
        list.add(4);

        System.out.println(list.size());

        int el2 = list.remove(2);
        System.out.println(el2);

        System.out.println(list.size());

        System.out.println(list.isEmpty());*/

        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        System.out.println(linkedList.size);

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println(linkedList.size);

        linkedList.print();
        System.out.println(linkedList.removeFirst());
        linkedList.print();
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList.size);
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList.size);
    }
}


