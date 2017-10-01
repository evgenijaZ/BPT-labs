package main.java.com.company.Music;
import java.io.Serializable;
import java.util.Objects;

/**
 * Song Class uses for storing information about song
 */

public class Song extends MusicalObject  implements Serializable { //песня, наследник абстрактного класса
    /**
     * genre of song
     * */
    private String genre; //жанр
    /**
     * author of song
     * */
    private String author; //автор

    /**
     * Constructor to initialize song
     * @param name an initial song name
     * @param author an initial song author
     * @param genre an initial song genre
     * @param length an initial song length (in seconds)
     */
    public Song(String name, String author, String genre, int length) {  //конструктор
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.length = length;
    }

    /**
     * get song genre
     * @return song genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * to set a genre of a song
     * @param genre song genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }
    /**
     * get song author
     * @return song author
     */

    public String getAuthor() {
        return author;
    }
    /**
     * to set a author of a song
     * @param author song genre
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * to represent song as string
     * @return string representation of the song
     */
    @Override
    public String toString() { //перегруженный виртуальный метод toString()
        return "Song{" +
                "name=" + name +
                ",author=" + author  +
                ",genre=" + genre +
                ",length=" + length  +
                '}';
    }

    /**
     * to print a song with field and values in console
     */
    @Override
    public void print() { //реализация абстрактного метода
        System.out.println("\"" + this.getName() + " - " + this.getAuthor() + "\"" + "\t" + this.getGenre() + " " + this.getLength());
    }

    /**
     * override method
     * to compare song with other object
     * @param obj object to compare with
     * @return true, if object is equal to song
     */

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
                return Objects.equals(tmp.name, this.name) && Objects.equals(tmp.author, this.author) && Objects.equals(tmp.genre, this.genre) && tmp.length == this.length;
            }
        }
    }
}