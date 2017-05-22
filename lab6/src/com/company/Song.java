package com.company;

class Song {
    private int length;
    private String name;
    private String genre;

    Song(String name, String genre, int length) {
        this.name = name;
        this.genre = genre;
        this.length = length;
    }

    int getLength() {
        return this.length;
    }

    void setLength(int len) {
        this.length = len;
    }

    String getGenre() {
        return this.genre;
    }

    void setGenre(String gen) {
        this.genre = gen;
    }

    String getName() {
        return this.name;
    }

    void setName(String nam) {
        this.genre = nam;
    }

    int compareTo(Song t) {
        return this.getGenre().compareTo(t.getGenre());
    }

    void print() {
        System.out.println('"' + this.getName() + '"' + "    " + this.getGenre() + " " + this.getLength());
    }
}