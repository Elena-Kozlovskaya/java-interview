package com.kozlovskaya.java.interview.homework.lesson_2;

public class MyLinkedList<E> {
    protected int size;
    protected Node<E> firstElement;
    protected Node<E> lastElement;

    /**
     * Добавление нового элемента в LinkedList в конец
     *
     * @param element
     * @return true;
     */
    public boolean addLast(E element) {
        if (element != null) {
            Node<E> newLast = new Node<>();
            newLast.element = element;
            if (lastElement != null) { //если текущий последний элемент существует
                newLast.head = lastElement; // голова добавляемого в конец елемента равна существующему последнему элементу
                lastElement.tail = newLast; // хвост существующего посл.эл == новому посл.эл
            }
            lastElement = newLast;
            if (firstElement == null) {
                firstElement = lastElement;
            }
            size++;
            return true;
        }
        return false;
    }

    /**
     * Добавление нового элемента в LinkedList в начало
     *
     * @param element
     * @return true;
     */
    public boolean addFirst(E element) {
        if (element != null) {
            Node<E> newFirst = new Node<>();
            newFirst.element = element;
            if (firstElement != null) { //если текущий первый элемент существует
                newFirst.tail = firstElement; // хвост добавляемого в начало елемента равен существующему первому элементу
                firstElement.head = newFirst; // голова существующего перв.эл == новому перв.эл
            }
            firstElement = newFirst;
            if (lastElement == null) {
                lastElement = firstElement;
            }
            size++;
            return true;
        }
        return false;
    }

    /**
     * Добавление нового элемента в LinkedList (по умолчанию в конец)
     *
     * @param element
     * @return true;
     */
    public boolean add(E element) {
        addLast(element);
        return true;
    }

    /**
     * Размер LinkedList
     *
     * @return int
     */
    public int size() {
        return size;
    }

    /**
     * Проверка LinkedList на пустоту
     *
     * @return true если первый элемент отсутсвует
     */
    public boolean isEmpty() {
        return firstElement == null;
    }

    /**
     * Удаление первого элемента
     * @return удаленный элемент
     */
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removedElement = firstElement;
        firstElement = firstElement.tail;
        if (firstElement == null) { //если это был единственный элемент
            lastElement = null;
        } else {
            firstElement.head = null; //если не единственный
        }
        size--;
        return removedElement.element;
    }

    /**
     * Удаление последнего элемента
     * @return удаленный элемент
     */
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removedElement = lastElement;
        lastElement = lastElement.head;
        if (lastElement == null) { //если это был единственный элемент
            firstElement = null;
        } else {
            lastElement.tail = null; //если не единственный
        }
        size--;
        return removedElement.element;
    }

    /**
     * Удаление элемента (по умолчанию первого)
     * @return удаленный элемент
     */
    public E remove(){
       return removeFirst();
    }

    /**
     * Получение первого элемента
     * @return первый элемент
     */
    public E getFirst(){
        if(isEmpty()){
            return null;
        }
        return firstElement.element;
    }

    /**
     * Получение последнего элемента
     * @return последний элемент
     */
    public E getLast(){
        if(isEmpty()){
            return null;
        }
        return lastElement.element;
    }

    /**
     * Вывод элемента
     */
    public void print(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        Node<E> current = firstElement;

        while (current != null){
            stringBuilder.append(current.element);
            if(current.tail != null){
                stringBuilder.append("->");
            }
            current = current.tail;
        }
        return stringBuilder.append("]").toString();
    }

    private class Node<E>{
        E element;
        Node<E> head;
        Node<E> tail;
    }
}
