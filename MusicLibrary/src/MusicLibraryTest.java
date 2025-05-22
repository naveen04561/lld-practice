import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class MusicLibraryTest {

    @Test
    public void testPlayAndTopSongs() {
        MusicLibrary lib = new MusicLibrary();

        lib.playSong("user1", "songA");
        lib.playSong("user2", "songA");
        lib.playSong("user1", "songB");
        lib.playSong("user3", "songA");
        lib.playSong("user2", "songC");

        List<String> top = lib.getTopSongs(2);
        assertEquals("songA", top.getFirst());
        assertEquals(2, top.size());
    }

    @Test
    public void testRecentSongs() {
        MusicLibrary lib = new MusicLibrary();

        lib.playSong("user1", "songA");
        lib.playSong("user2", "songB");
        lib.playSong("user3", "songC");
        lib.playSong("user4", "songD");

        List<String> recent = lib.getRecentSongs();
        assertEquals(List.of("songD", "songC", "songB"), recent);
    }

    @Test
    public void testLessThanThreeRecentSongs() {
        MusicLibrary lib = new MusicLibrary();

        lib.playSong("user1", "songX");
        lib.playSong("user2", "songY");

        List<String> recent = lib.getRecentSongs();
        assertEquals(List.of("songY", "songX"), recent);
    }
}
