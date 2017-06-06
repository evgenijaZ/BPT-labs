package main.java.com.company.Music;

public class MusicalNode<T extends Song> { //обобщенный класс, элемент коллекции Альбом
    private MusicalNode <?> next; //указатель на следующий элемент в списке
    private T value; //значение

    MusicalNode() {
        this.next = null;
    }

    public MusicalNode(Object o) {
        if (o != null) {
            this.value = (T) o;
            this.next = null;
        }
    }


    boolean hasNext() { //имеется ли следующий элемент
        return !(next == null);
    }

    MusicalNode getNext() { //возвращает следующий элемент
        return next;
    }

    void setNext(MusicalNode <?> next) { //устанавливает следующий элемент
        this.next = next;
    }

    T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() { //перегруженный виртуальный метод toString()
        return value.toString();
    }

    @Override
    public boolean equals(Object obj) { //перегруженный виртуальный метод equals()
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