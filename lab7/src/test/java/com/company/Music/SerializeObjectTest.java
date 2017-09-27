package test.java.com.company.Music;

import main.java.com.company.Music.Album;
import main.java.com.company.Music.MusicalNode;
import main.java.com.company.Music.Song;
import org.junit.jupiter.api.Test;

import main.java.com.company.Music.Stream;

import static org.junit.Assert.assertEquals;

class SerializeObjectTest {
    @Test
    void serializeDeserializeCollectionAsObject() {
        MusicalNode node1 = new MusicalNode <Song>(new Song("Autopilot", "Kodaline", "pop", 259));
        MusicalNode node2 = new MusicalNode <Song>(new Song("Luck", "American Authors", "rock", 245));
        MusicalNode node3 = new MusicalNode <Song>(new Song("The nights", "Avicii", "indie", 245));
        MusicalNode node4 = new MusicalNode <Song>(new Song("It's about time", "Barcelona", "pop", 232));
        MusicalNode node5 = new MusicalNode <Song>(new Song("Be Clear", "Fiction", "pop", 234));
        Album<Song> album = new Album <>();
        album.add(node5);
        album.add(node4);
        album.add(node3);
        album.add(node2);
        album.add(node1);

        Stream str = new Stream();
        str.SerializeObject(album, "A.dat");
        boolean result =((Album) str.DeserializeObject("A.dat")).equals(album);
        assertEquals(true,result);
    }
    @Test

    void serializeDeserializeObject() {
        MusicalNode node = new MusicalNode <Song>(new Song("Autopilot", "Kodaline", "pop", 259));
        Stream str = new Stream();
        str.SerializeObject(node, "B.dat");
        boolean result =((MusicalNode) str.DeserializeObject("B.dat")).equals(node);
        assertEquals(true,result);
    }

}