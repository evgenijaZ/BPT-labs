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


}