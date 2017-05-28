package com.company;

import java.util.*;
import java.util.function.UnaryOperator;

@SuppressWarnings("unchecked")
class Album<E extends Song> implements List {
    private MusicalNode <E> head = null;
    private int size = 0;

    @Override
    public String toString() {
        return "Album{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }

    void print() {
        MusicalNode tmp = head;
        while (tmp != null) {
            System.out.println(tmp.toString());
            tmp = tmp.getNext();
        }

    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }


    @Override
    public boolean contains(Object o) {
        if (o != null) {
            MusicalNode temp = head;
            while (temp != null) {
                if (temp.equals(o)) return true;
                temp = temp.getNext();
            }
        }
        return false;
    }

    @Override
    public Iterator <E> iterator() {
//        return new Iterator <E>() {
//            private MusicalNode <E> current = head;
//
//            @Override
//            public boolean hasNext() {
//                return current.hasNext();
//            }
//
//            @Override
//            public E next() throws IndexOutOfBoundsException {
//                E result =  current.getValue();
//                if (!current.hasNext()) throw new IndexOutOfBoundsException("End of list.");
//                current =  current.getNext();
//                return result;
//            }
//        };
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        if (o != null) {
            if (size == 0 || head == null) {
                head = new MusicalNode <>(o);
            } else {
                MusicalNode temp = new MusicalNode <>(o);
                temp.setNext(head);
                head = temp;
            }
            size++;
//            System.out.println(head.toString());
            return true;
        } else
            return false;
    }

    @Override
    public boolean remove(Object o) {
        if (o != null && MusicalNode.class == o.getClass()) {
            if (head.equals(o)) {
                head = head.getNext();
            } else {
                MusicalNode tmp = head;
                while (tmp.hasNext()) {
                    if (tmp.getNext().equals(o)) {
                        tmp.setNext(tmp.getNext().getNext());
                        break;
                    }
                    tmp = tmp.getNext();
                }
            }
            size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator operator) {

    }

    @Override
    public void sort(Comparator c) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        if (index < size()) {
            MusicalNode temp = head;
            while (index > 0 && temp != null) {
                index--;
                temp = temp.getNext();
            }
            return temp;
        }
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        if (index < size()) {
            MusicalNode temp = head;
            MusicalNode result = null;
            while (index > 0 && temp != null) {
                if (index == 1) {
                    result = temp.getNext();
                    temp.setNext(temp.getNext().getNext());
                }
                temp = temp.getNext();
                index--;
            }
            size--;
            return result;
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        if (o != null) {
            int index = 0;
            MusicalNode temp = head;
            while (temp != null) {
                if (temp.equals(o)) return index;
                index++;
                temp = temp.getNext();
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }


    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}