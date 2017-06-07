package main.java.com.company.Music;

import java.util.*;
import java.util.function.UnaryOperator;

public class Album<E extends Song> implements List {
    private MusicalNode <?> head = null; //указатель на вершину списка
    private int size = 0; //размер

    public Album() {
        head = null;
        size = 0;
    }

    public Album(Object o) {
        head = new MusicalNode <>(o);
        size = 1;
    }

    public Album(Collection <E> c) {
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

    public void print() { //печать элементов списка
        int i = 0;
        Iterator <MusicalNode> it = iterator();
        while (it.hasNext()) {
            System.out.println(i + ": " + it.next().toString());
            i++;
        }
        System.out.println(i + ": " + it.next().toString());

    }

    @Override
    public int size() { //размер
        return this.size;
    }

    @Override
    public boolean isEmpty() { //true, если список пустой
        return size() == 0;
    }


    @Override
    public boolean contains(Object obj) {  //true, если список содержит в себе оbj
        return indexOf(obj) >= 0;
    }


    @Override
    public Object[] toArray() { // возвращает массив всех объектов списка
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
        if (o != null && o.getClass() == MusicalNode.class) {
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
    public boolean remove(Object o) { //удалить объект; true,если успешно
        if (size != 0 && o != null && MusicalNode.class == o.getClass()) {
            if (head.equals(o)) {
                if (size > 1) {
                    head = head.getNext();
                } else {
                    head = null;
                }
                return true;
            } else {
                MusicalNode tmp = head;
                while (tmp.hasNext()) {
                    if (tmp.getNext().equals(o)) {
                        tmp.setNext(tmp.getNext().getNext());
                        size--;
                        return true;
                    }
                    tmp = tmp.getNext();
                }
            }

        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) { //добавить коллекцию в список; true,если успешно
        if (c != null) {
            Object[] collection = c.toArray();
            boolean result = false;
            for (int i = 0; i < c.size(); i++) {
                if (this.add(collection[i])) result = true;
            }
            return result;
        } else return false;
    }

    @Override
    public boolean addAll(int index, Collection c) { //добавить коллекцию начиная с индекса index; true,если успешно
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
    public void clear() { //очистить список
        head = null;
        size = 0;
    }

    @Override
    public Object get(int index) { //возвращает объект по индексу
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
    public Object set(int index, Object element) { //установить новое значение элемента по индексу, возвращает старое значение
        Objects.requireNonNull(element, "Collection" + element + "cannot be null!");
        MusicalNode newNode = new MusicalNode(element);
        if (index >= size) return null;
        Object oldNode = get(index);
        this.add(index, element);
        this.remove(index + 1);
        return oldNode;
    }

    @Override
    public void add(int index, Object element) { //добавить элемент по индексу
        Objects.requireNonNull(element, "Object" + element + "cannot be null!");
        if (size == 0 || head == null) {
            if (index == 0)
                head = new MusicalNode <E>(element);
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
    public Object remove(int index) { //удалить элемент по индексу, возвращает удаленный объект
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
    public int indexOf(Object o) { //возвращает индекс первого вхождения объекта в списке, -1, если отсутсвует
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
    public int lastIndexOf(Object o) { //возвращает последний индекс объекта в списке, -1, если отсутвует
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


    public int totalLength() { //возвращает суммарную длину треков списка
        int total = 0;
        MusicalNode temp = head;
        while (temp != null) {
            total += ((Song) temp.getValue()).getLength();
            temp = temp.getNext();
        }
        return total;
    }

    public ArrayList <MusicalNode> search(int a, int b) { //возвращает список, содержащий элементы, длина которых в диавазоне (a;b)
        ArrayList <MusicalNode> searchResult = new ArrayList <>();

        MusicalNode temp = head;
        int length;
        while (temp != null) {
            length = ((E) temp.getValue()).getLength();
            if ((length <= b) && (length >= a)) {
                searchResult.add(temp);
            }
            temp = temp.getNext();
        }
        return searchResult;
    }

    public void sort() { //сортировка
        ArrayList <Song> storage = new ArrayList <>();
        MusicalNode temp = head;
        while (temp != null) {
            Song r = (E) (temp.getValue());
            storage.add(r);
            temp = temp.getNext();
        }
        storage.sort(Comparator.comparing(Song::getLength));
        this.clear();
        for (Song aStorage : storage) {
            this.add(aStorage);
        }
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
    public boolean containsAll(Collection c) { //true, если список содержит все элементы коллкции
        ArrayList storage = new ArrayList <>(c);
        for (Object aStorage : storage) {
            if (!this.contains(aStorage))
                return false;
        }
        return true;
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
    public Iterator <MusicalNode> iterator() {
        return new Iterator <MusicalNode>() {
            private MusicalNode current = head;

            @Override
            public boolean hasNext() {
                return current.hasNext();
            }

            @Override
            public MusicalNode next() {
                MusicalNode result  = current;
                current = current.getNext();
                return result;
            }

        };
    }
}