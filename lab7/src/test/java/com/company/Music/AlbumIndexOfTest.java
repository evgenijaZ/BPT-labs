package test.java.com.company.Music;

import main.java.com.company.Music.Album;
import main.java.com.company.Music.MusicalNode;
import main.java.com.company.Music.Song;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.*;

public class AlbumIndexOfTest {
    @Before
    public void before() {
        System.out.println("Test for indexOf() begin");
    }

    @After
    public void after() {
        System.out.println("Test for indexOf() complete");
    }

    @Test
    public void testSizeOfInEmptyAlbum() throws Exception {
        Album album = new Album();
        MusicalNode node1 = new MusicalNode <Song>(new Song("Autopilot", "Kodaline", "pop", 259));
        int output  = album.indexOf(node1);
        Assert.assertEquals(-1, output);
    }

    @Test
    public void testIndexOfInAlbumWithOneItem() throws Exception {
        Album album = new Album();
        MusicalNode node1 = new MusicalNode <Song>(new Song("Autopilot", "Kodaline", "pop", 259));
        album.add(node1);
        int output  = album.indexOf(node1);
        assertEquals(0, output);
    }

    @Test
    public void testIndexOfInAlbumWithoutThisItem() throws Exception {
        Album album = new Album();
        MusicalNode node1 = new MusicalNode <Song>(new Song("Autopilot", "Kodaline", "pop", 259));
        MusicalNode node2 = new MusicalNode <Song>(new Song("Luck", "American Authors", "rock", 245));
        album.add(node1);
        int output  = album.indexOf(node2);
        assertEquals(-1, output);
    }

    @Test
    public void testIndexOfInAlbumWithFiveItem() throws Exception {
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
        int output  = album.indexOf(node4);
        assertEquals(3, output);
    }
}