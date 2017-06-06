package test.java.com.company.Music;

import main.java.com.company.Music.Album;
import main.java.com.company.Music.MusicalNode;
import main.java.com.company.Music.Song;
import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

public class AlbumSizeTest {
    @Before
    public void before() {
        System.out.println("Test for size() begin");
    }

    @After
    public void after() {
        System.out.println("Test for size() complete");
    }

    @Test
    public void testSizeOfEmptyAlbum() throws Exception {
        Album album = new Album();
        int output  = album.size();
        Assert.assertEquals(0, output);
    }

    @Test
    public void testSizeOfAlbumWithOneItem() throws Exception {
        Album album = new Album();
        MusicalNode node1 = new MusicalNode <Song>(new Song("Autopilot", "Kodaline", "pop", 259));
        album.add(node1);
        int output  = album.size();
        assertEquals(1, output);
    }

    @Test
    public void testSizeOfAlbumWithFiveItem() throws Exception {
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
        int output  = album.size();
        assertEquals(5, output);
    }
}