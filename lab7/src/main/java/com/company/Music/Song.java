package main.java.com.company.Music;

import java.io.Serializable;

public class Song extends MusicalObject  implements Serializable { //песня, наследник абстрактного класса

    private String genre; //жанр
    private String author; //автор

    public Song(String name, String author, String genre, int length) {  //конструктор
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.length = length;
    }



    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() { //перегруженный виртуальный метод toString()
        return "Song{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", length=" + length + "ms" +
                '}';
    }

    @Override
    public void print() { //реализация абстрактного метода
        System.out.println("\"" + this.getName() + " - " + this.getAuthor() + "\"" + "\t" + this.getGenre() + " " + this.getLength());
    }


    @Override
    public boolean equals(Object obj) { //перегруженный виртуальный метод equals()
        {
            if (obj == this)
                return true;
            if (obj == null)
                return false;
            if (!(getClass() == obj.getClass()))
                return false;
            else {
                Song tmp = (Song) obj;
                if (tmp.name == this.name && tmp.author == this.author && tmp.genre == this.genre && tmp.length == this.length)
                    return true;
                else
                    return false;
            }
        }
    }
}