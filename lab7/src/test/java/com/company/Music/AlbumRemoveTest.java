package test.java.com.company.Music;

import main.java.com.company.Music.Album;
import main.java.com.company.Music.MusicalNode;
import main.java.com.company.Music.Song;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AlbumRemoveTest {
    @Test
    public void testRemoveFromEmptyAlbum() throws Exception {
        Album album = new Album();
        MusicalNode node1 = new MusicalNode <Song>(new Song("Autopilot", "Kodaline", "pop", 259));
        boolean output = album.remove(node1);
        assertEquals(false, output);
    }

    @Test
    public void testRemoveFromAlbumWithThisElement() throws Exception {
        Album album = new Album();
        MusicalNode node1 = new MusicalNode <Song>(new Song("Autopilot", "Kodaline", "pop", 259));
        MusicalNode node2 = new MusicalNode <Song>(new Song("Luck", "American Authors", "rock", 245));
        album.add(node1);
        album.add(node2);
        boolean output = album.remove(node2);
        assertEquals(true, output);
    }

    @Test
    public void testRemoveFromAlbumWithoutThisElement() throws Exception {
        Album album = new Album();
        MusicalNode node1 = new MusicalNode <Song>(new Song("Autopilot", "Kodaline", "pop", 259));
        MusicalNode node2 = new MusicalNode <Song>(new Song("Luck", "American Authors", "rock", 245));
        album.add(node1);
        boolean output = album.remove(node2);
        assertEquals(false, output);
    }
    @Test
    public void testAddNotMNodeInAlbum() throws Exception {
        Album album = new Album();
        boolean output = album.remove(null);
        assertEquals(false, output);
    }
}
