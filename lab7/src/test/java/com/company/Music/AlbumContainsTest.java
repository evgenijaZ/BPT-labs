package test.java.com.company.Music;

import main.java.com.company.Music.Album;
import main.java.com.company.Music.MusicalNode;
import main.java.com.company.Music.Song;
import org.junit.Test;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

public class AlbumContainsTest {
    @Test
    public void testContainsOfEmptyAlbum() throws Exception {
        Album album = new Album();
        MusicalNode node1 = new MusicalNode <Song>(new Song("Autopilot", "Kodaline", "pop", 259));
        boolean output  = album.contains(node1);
        assertEquals(false, output);
    }

    @Test
    public void testContainsOfAlbumWithOneElement() throws Exception {
        Album album = new Album();
        MusicalNode node1 = new MusicalNode <Song>(new Song("Autopilot", "Kodaline", "pop", 259));
        album.add(node1);
        boolean output  = album.contains(node1);
        assertEquals(true, output);
    }

    @Test
    public void testContainsOfAlbumWithoutThisElement() throws Exception {
        Album album = new Album();
        MusicalNode node1 = new MusicalNode <Song>(new Song("Autopilot", "Kodaline", "pop", 259));
        MusicalNode node2 = new MusicalNode <Song>(new Song("Luck", "American Authors", "rock", 245));
        album.add(node1);
        boolean output  = album.contains(node2);
        assertEquals(false, output);
    }
}
