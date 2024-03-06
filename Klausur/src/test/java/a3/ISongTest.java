package a3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ISongTest {

    @Test
    void fail() {
        Assertions.fail("BITTE DIE KOMMENTARZEICHEN IN DER TESTKLASSE ENTFERNEN! DAMIT DIE TESTS AUSGEFÜHRT WERDEN KÖNNEN.");
    }
    /*
    private static final Line L1 = new Line("This is the first line of my simple song");
    private static final Line L2 = new Line("This is the second line of my simple song");
    private static final Line L3 = new Line("This is another line of my simple song");
    private static final Line L4 = new Line("Yeah, Yeah, Yeah!");

    private ISong song1;
    private ISong song2;
    private ISong song3;
    private ISong song4;
    private ISong song5;
    private ISong song6;

    @BeforeEach
    public void setUp() throws Exception {
        song1 = new Song(L1, L2, L4, L3, L4);
        song2 = new Song(L1, L2, L4);
        song3 = new ComposedSong(song1, song2);
        song4 = new BoringSong(song2);
        song5 = new ComposedSong(song3, song4);
        song6 = new Song(L1, L2, L3);
    }

    @Test
    void testLength() {
        assertEquals(5, song1.length());
        assertEquals(3, song2.length());
        assertEquals(8, song3.length());
        assertEquals(6, song4.length());
        assertEquals(14, song5.length());
    }


    @Test
    void testNumberOfStrophes() {
        assertEquals(2, song1.numberOfStrophes());
        assertEquals(1, song2.numberOfStrophes());
        assertEquals(3, song3.numberOfStrophes());
        assertEquals(2, song4.numberOfStrophes());
        assertEquals(5, song5.numberOfStrophes());
    }

    @Test
    void testComposedPoem() {
        assertThrows((IllegalArgumentException.class), () -> new ComposedSong(song1, song6));
    }

    @Test
    void testToString() {
        String result = """
                This is the first line of my simple song
                This is the second line of my simple song
                Yeah, Yeah, Yeah!
                This is another line of my simple song
                Yeah, Yeah, Yeah!
                This is the first line of my simple song
                This is the second line of my simple song
                Yeah, Yeah, Yeah!
                This is the first line of my simple song
                This is the second line of my simple song
                Yeah, Yeah, Yeah!
                This is the first line of my simple song
                This is the second line of my simple song
                Yeah, Yeah, Yeah!
                """;
        assertEquals(result, song5.toString());
    }
    */

}