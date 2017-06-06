package main.java.com.company.Music;

abstract class MusicalObject { //абстрактный класс
    String name; // название композиции
    int length; // длина композиции

    abstract void print(); // абстрактный метод, должен быть переопределен в наследниках

    String getName() { //возвращает название
        return name;
    }

    public void setName(String name) { //устанавливает название
        this.name = name;
    }

    int getLength() { //возвращает длину
        return length;
    }

    public void setLength(int length) { //устанавливает длину
        this.length = length;
    }
}
