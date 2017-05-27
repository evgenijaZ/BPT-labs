package com.company;

public class MusicalNode<T> {
    private MusicalNode <T> next;
    private T value;

    MusicalNode() {
        this.next = null;
    }

    MusicalNode(Object o) {
        if (o != null) {
            this.value = (T) o;
            this.next = null;
        }
    }


    boolean hasNext() {
        return !(next == null);
    }

    MusicalNode getNext() {
        return next;
    }

    void setNext(MusicalNode<T> next) {
        this.next = next;
    }

    T getValue() {
        return value;
    }

    void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null)
            return false;
        if (!(getClass() == obj.getClass()))
            return false;
        else {
            MusicalNode tmp = (MusicalNode) obj;
            return tmp.toString().equals(this.toString());
        }
    }
}