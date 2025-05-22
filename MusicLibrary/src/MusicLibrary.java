import java.util.*;

public class MusicLibrary {
    // songId -> set of unique userIds
    private final Map<String, Set<String>> songToUsers = new HashMap<>();

    // queue for recent songs (songId + userId), size limited to 3
    private final Deque<String> recentSongs = new ArrayDeque<>();
    private static final int RECENT_LIMIT = 3;

    // Play a song by a user
    public void playSong(String userId, String songId) {
        songToUsers.computeIfAbsent(songId, k -> new HashSet<>()).add(userId);

        String playRecord = songId + "|" + userId;
        recentSongs.addLast(playRecord);
        if (recentSongs.size() > RECENT_LIMIT) {
            recentSongs.pollFirst();
        }
    }

    // Get top N songs by unique user count
    public List<String> getTopSongs(int n) {
        List<Map.Entry<String, Set<String>>> list = new ArrayList<>(songToUsers.entrySet());
        list.sort((a, b) -> b.getValue().size() - a.getValue().size());

        List<String> result = new ArrayList<>();
        for (int i = 0; i < Math.min(n, list.size()); i++) {
            result.add(list.get(i).getKey());
        }
        return result;
    }

    // Get 3 most recently played songs (most recent first)
    public List<String> getRecentSongs() {
        List<String> result = new ArrayList<>();
        Iterator<String> desc = recentSongs.descendingIterator();
        while (desc.hasNext()) {
            String record = desc.next();
            String songId = record.split("\\|")[0];
            result.add(songId);
        }
        return result;
    }
}
