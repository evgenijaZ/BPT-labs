package com.company;

class Song extends MusicalObject {

    private String genre;
    private String author;

    Song(String name, String author, String genre, int length) {
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
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", length=" + length + "ms" +
                '}';
    }

    @Override
    void print() {
        System.out.println("\"" + this.getName() + " - " + this.getAuthor() + "\"" + "\t" + this.getGenre() + " " + this.getLength());
    }


    @Override
    public boolean equals(Object obj) {
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