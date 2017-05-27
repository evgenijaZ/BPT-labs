package com.company;

import java.util.*;
import java.util.function.UnaryOperator;

class Album<E extends Song> implements List {
    public MusicalNode <E> head = null;
    private int size = 0;

    @Override
    public String toString() {
        return "Album{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }

    public void print() {
        MusicalNode tmp = head;
        while (tmp!=null){
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
            for (Object o1 : this) {
                if (o.equals(o1))
                    return true;
            }
        }
        return false;
    }

    @Override
    public Iterator <E> iterator() {
        return new Iterator <E>() {
            private MusicalNode <E> current = head;

            @Override
            public boolean hasNext() {
                return current.hasNext();
            }

            @Override
            public E next() throws IndexOutOfBoundsException {
                E result = current.getValue();
                if (!current.hasNext()) throw new IndexOutOfBoundsException("End of list.");
                current = current.getNext();
                return result;
            }
        };
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
                MusicalNode tmp=head;
                while (tmp.hasNext()){
                    if(tmp.getNext().equals(o))
                    {
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
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
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