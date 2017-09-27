package test.java.com.company.Music;

import main.java.com.company.Music.Album;
import main.java.com.company.Music.MusicalNode;
import main.java.com.company.Music.Song;
import main.java.com.company.Music.Stream;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class SerializeCollectionTest {
    @Test
    void serializeDeserializeCollection() {
        MusicalNode node1 = new MusicalNode <Song>(new Song("Autopilot", "Kodaline", "pop", 259));
        MusicalNode node2 = new MusicalNode <Song>(new Song("Luck", "American Authors", "rock", 245));
        MusicalNode node3 = new MusicalNode <Song>(new Song("The nights", "Avicii", "indie", 245));
        MusicalNode node4 = new MusicalNode <Song>(new Song("It's about time", "Barcelona", "pop", 232));
        MusicalNode node5 = new MusicalNode <Song>(new Song("Be Clear", "Fiction", "pop", 234));
        Album <Song> album = new Album<>();
        album.add(node5);
        album.add(node4);
        album.add(node3);
        album.add(node2);
        album.add(node1);
        Stream str = new Stream();
        str.SerializeCollection(album, "C.dat");
        boolean result = album.equals(str.DeserializeCollection("C.dat"));
        assertEquals(true,result);
    }

}