package com.company;

import java.util.*;
import java.util.function.UnaryOperator;

class Album<E extends Song> implements List {
    private MusicalNode <?> head = null;
    private int size = 0;

    Album() {
        head = null;
        size = 0;
    }

    Album(Object o) {
        head = new MusicalNode <>(o);
        size = 1;
    }

    Album(Collection <E> c) {
        this.addAll(c);
        size = c.size();
    }

    @Override
    public String toString() {
        return "Album{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }

    void print() {
        MusicalNode tmp = head;
        int i = 0;
        while (tmp != null) {
            System.out.println(i + ": " + tmp.toString());
            tmp = tmp.getNext();
            i++;
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
        return indexOf(o) >= 0;
    }


    @Override
    public Object[] toArray() {
        MusicalNode item = head;
        Object[] array = new Object[size];
        int i = 0;
        while (item != null && i < size) {
            array[i] = item;
            item = item.getNext();
        }
        return array;
    }

    @Override
    public boolean add(Object o) {
        if (o != null) {
            if (size == 0 || head == null) {
                head = new MusicalNode <E>(o);
            } else {
                MusicalNode temp = new MusicalNode <>(o);
                temp.setNext(head);
                head = temp;
            }
            size++;
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
        if (c != null) {
            Object[] collection = c.toArray();
            boolean result = false;
            for (int i = 0; i < c.size(); i++) {
                result &= this.add(collection[i]);
            }
            return result;
        } else return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        if (index >= size) return false;
        Objects.requireNonNull(c, "Collection" + c + "cannot be null!");
        Object[] collection = c.toArray();
        boolean result = false;
        for (int i = 0; i < c.size(); i++) {
            this.add(index, collection[i]);
            index++;
        }
        return true;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
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
        Objects.requireNonNull(element, "Collection" + element + "cannot be null!");
        MusicalNode newNode = new MusicalNode(element);
        if (index >= size) return null;
        Object oldNode = get(index);
        this.add(index, element);
        this.remove(index + 1);
        return oldNode;
    }

    @Override
    public void add(int index, Object element) {
        Objects.requireNonNull(element, "Object" + element + "cannot be null!");
        if (size == 0 || head == null) {
            if (index == 0)
                head = new MusicalNode <E>(element);
            else return;
        } else {
            MusicalNode temp = head;
            while (temp != null) {
                if (index == indexOf(temp.getNext())) {
                    MusicalNode <E> newElement = new MusicalNode <>(element);
                    newElement.setNext(temp.getNext());
                    temp.setNext(newElement);
                    size++;
                    return;
                }
                temp = temp.getNext();
            }
        }
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
        Objects.requireNonNull(o, "Object" + o + "cannot be null!");
        int index = 0;
        int result = -1;
        MusicalNode temp = head;
        while (temp != null) {
            if (temp.equals(o)) result = index;
            index++;
            temp = temp.getNext();
        }
        return result;
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

    @Override
    public void replaceAll(UnaryOperator operator) {
    }

    @Override
    public void sort(Comparator c) {
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
}