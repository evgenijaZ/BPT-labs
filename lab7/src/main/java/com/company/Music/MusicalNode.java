package main.java.com.company.Music;

public class MusicalNode<T> {
    private MusicalNode <?> next;
    private T value;

    MusicalNode() {
        this.next = null;
    }

    public MusicalNode(Object o) {
        if (o != null) {
            this.value = (T) o;
            this.next = null;
        }
    }


    public boolean hasNext() {
        return !(next == null);
    }

    public MusicalNode getNext() {
        return next;
    }

    public void setNext(MusicalNode <?> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
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