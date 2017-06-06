package main.java.com.company.Music;
public class Main {

    public static void main(String[] args) {
        //test
        MusicalNode node1 = new MusicalNode <Song>(new Song("Autopilot", "Kodaline", "pop", 259));
        MusicalNode node2 = new MusicalNode <Song>(new Song("Luck", "American Authors", "rock", 245));
        MusicalNode node3 = new MusicalNode <Song>(new Song("The nights", "Avicii", "indie", 245));
        MusicalNode node4 = new MusicalNode <Song>(new Song("It's about time", "Barcelona", "pop", 232));
        MusicalNode node5 = new MusicalNode <Song>(new Song("Be Clear", "Fiction", "pop", 234));
        Album <Song> album = new Album <>();
        album.add(node5);
        album.add(node4);
        album.add(node3);
        album.add(node2);
        album.add(node1);
    }

}
