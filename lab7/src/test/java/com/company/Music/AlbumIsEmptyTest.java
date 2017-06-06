package test.java.com.company.Music;

import main.java.com.company.Music.Album;
import main.java.com.company.Music.MusicalNode;
import main.java.com.company.Music.Song;
import org.junit.Test;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

public class AlbumIsEmptyTest {
    @Test
    public void testIsEmptyOfEmptyAlbum() throws Exception {
        Album album = new Album();
        boolean output  = album.isEmpty();
        assertEquals(true, output);
    }

    @Test
    public void testIsEmptyOfAlbumWithOneItem() throws Exception {
        Album album = new Album();
        MusicalNode node1 = new MusicalNode <Song>(new Song("Autopilot", "Kodaline", "pop", 259));
        album.add(node1);
        boolean output  = album.isEmpty();
        assertEquals(false, output);
    }

}
