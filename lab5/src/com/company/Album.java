package com.company;

import java.util.ArrayList;
import java.util.Comparator;

class Album {
    private ArrayList <Song> storage;
    private ArrayList <Song> searchResult;

    ArrayList <Song> getSearchResult() {
        return searchResult;
    }

    Song getSearchResult(int i) {
        return searchResult.get(i);
    }

    void activate() {
        if (this.storage == null)
            this.storage = new ArrayList <>();
    }

    int size() {
        return this.storage.size();
    }

    Song get(int index) {
        return this.storage.get(index);
    }

    public void set(int index, Song song) {
        storage.set(index, song);
    }

    void add(String name, String genre, int length) {
        storage.add(new Song(name, genre, length));
    }

    int totalLength() {
        int total = 0;
        for (Song t : storage) {
            total += t.getLength();
        }
        return total;
    }

    ArrayList <Song> search(int a, int b) {
        this.searchResult = new ArrayList <>();
        for (Song t : storage) {
            if ((t.getLength() <= b) && (t.getLength() >= a)) {
                searchResult.add(t);
            }
        }
        return searchResult;
    }

    void sort() {
        storage.sort(Comparator.comparing(Song::getGenre));
    }

}
