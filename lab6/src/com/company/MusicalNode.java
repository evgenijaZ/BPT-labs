package com.company;

public class MusicalNode<T> {

    private MusicalNode next;
    private MusicalNode previous;
    private T t;

    MusicalNode() {
        this.next = null;
        this.previous = null;
    }

    MusicalNode(T t) {
        this.t = t;
        this.next = null;
        this.previous = null;
    }

    MusicalNode(MusicalNode previous) {
        this.next = null;
        this.previous = previous;
    }

    MusicalNode getNext() {
        return next;
    }

    public void setNext(MusicalNode next) {
        this.next = next;
    }

    public MusicalNode getPrevious() {
        return previous;
    }

    public void setPrevious(MusicalNode previous) {
        this.previous = previous;
    }

    T getT() {
        return t;
    }

    void setT(T t) {
        this.t = t;
    }
}