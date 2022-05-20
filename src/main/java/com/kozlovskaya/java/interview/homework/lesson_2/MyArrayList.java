package com.kozlovskaya.java.interview.homework.lesson_2;


import java.util.Arrays;

public class MyArrayList<E> {
    private static final Object [] EMPTY_ARRAY = {};
    private static final Object [] DEFAULT_CAPACITY_EMPTY_ARRAY = {};
    Object[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int GROWTH_FACTOR = 5;
    public static final int SOFT_MAX_ARRAY_LENGTH = Integer.MAX_VALUE - 8;


    public MyArrayList(int initialCapacity){
        if(initialCapacity > 0){
            this.data = new Object[initialCapacity];
        } else if(initialCapacity == 0){
            this.data = EMPTY_ARRAY;
        } else {
            throw new IllegalArgumentException("Illegal capacity " + initialCapacity);
        }
    }

    public MyArrayList(){
        this.data = DEFAULT_CAPACITY_EMPTY_ARRAY;
    }

    public int size(){
        return size;
    }

    private void add(E element, Object[] data, int s){
        if(s == data.length) {
            data = grow();
        }
        data[s] = element;
        size = s + 1;
    }

    public void add(E e){
        add(e, data, size);
    }

    private Object[] grow() {
        int oldCapacity = data.length;
        if(oldCapacity > 0 || data != DEFAULT_CAPACITY_EMPTY_ARRAY) {
            if (data.length + GROWTH_FACTOR <= SOFT_MAX_ARRAY_LENGTH) {
                int newCapacity = data.length + GROWTH_FACTOR;
                return data = Arrays.copyOf(data, newCapacity);
            } else {
                throw new OutOfMemoryError();
            }
        } else {
            return data = new Object[Math.max(DEFAULT_CAPACITY, size + 1)];
        }
    }

    public E get(int index){
        checkIndex(index);
        return (E) data[index];
    }

    public E remove(int index){
        checkIndexForRemove(index);
        final Object[] newArray = data;
        E oldValue = (E) newArray[index];
        int newSize;
        if((newSize = size - 1) > index) {
            System.arraycopy(newArray, index + 1, newArray, index, newSize - 1);
        }
        newArray[size = newSize] = null;

            return oldValue;
    }

    private void checkIndex(int index){
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+ size);
    }

    private void checkIndexForRemove(int index){
        if (index > size-1 || index < 0)
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+ size);
    }

    public boolean isEmpty(){
        return size == 0;
    }



}
